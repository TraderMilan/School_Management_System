package org.example;

import org.example.classes.entities.Clazz;
import org.example.classes.entities.Student;
import org.example.classes.entities.Subject;

import java.util.*;

public class School {
    Scanner scanner = new Scanner(System.in);
    private final List<Clazz> classes;

    public School(List<Clazz> classes) {
        this.classes = classes;
    }

    public List<Clazz> getClasses() {
        return classes;
    }

    public void printSortedClassesByBestAvgGrades(School school) {

        HashMap<String, Double> clazz_avgGrade = new HashMap<>();

        for (Clazz clazz : school.getClasses()) {
            int count = 0;
            int sum = 0;
            for (Student student : clazz.getStudents()) {
                for (Integer grade : student.getSubjects().values()) {
                    sum += grade;
                    count++;
                }
            }
            clazz_avgGrade.put(clazz.getName(), (double) sum / count);
        }

        clazz_avgGrade.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(entry
                -> System.out.println("Trieda " + entry.getKey() + " ma priemernu znamku " + entry.getValue()));

    }

    public void printSubjectByBestGrade(School school) {
        HashMap<Subject, List<Integer>> copiedSubjects = new HashMap<>();
        copiedSubjects.put(Subject.ACCOUNTING, new ArrayList<>(0));
        copiedSubjects.put(Subject.CHEMISTRY, new ArrayList<>(0));
        copiedSubjects.put(Subject.ENGLISH, new ArrayList<>(0));
        copiedSubjects.put(Subject.MATHEMATICS, new ArrayList<>(0));
        copiedSubjects.put(Subject.PHYSICAL_EDUCATION, new ArrayList<>(0));
        copiedSubjects.put(Subject.PHYSICS, new ArrayList<>(0));

        for (Clazz clazz : school.getClasses()) {
            for (Student student : clazz.getStudents()) {
                for (Map.Entry<Subject, Integer> entry : student.getSubjects().entrySet()) {
                    if (copiedSubjects.containsKey(entry.getKey())) {
                        List<Integer> tmp = new ArrayList<>(copiedSubjects.get(entry.getKey()));
                        tmp.add(entry.getValue());
                        copiedSubjects.put(entry.getKey(), tmp);
                    }
                }
            }
        }
        HashMap<Subject, Double> subject_avg = new HashMap<>();
        for (Map.Entry<Subject, List<Integer>> cs : copiedSubjects.entrySet()) {
            int sum = 0;
            int count = 0;
            for (Integer grade : cs.getValue()) {
                sum += grade;
                count++;
            }
            subject_avg.put(cs.getKey(), (double) sum / count);
        }

        subject_avg.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(entry -> System.out.println(entry.getKey() + " ma priemernu znamku: " + entry.getValue()));

    }

    public void printStudentsByAvgGrade() {
        HashMap<String, Double> student_grade = new HashMap<>();

        System.out.println("V kotrej triede chces zistit priemerne znamky studentov? ");
        int i = 1;
        for (Clazz clazz : classes) {
            System.out.println(i + ". " + clazz.getName());
            i++;
        }

        int choice;
        while (true) {
            if (scanner.hasNext()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice <= classes.size() && choice >= 1) {
                    break;
                } else {
                    System.out.println("taka trieda neexistuje, skus este raz:");
                }
            } else {
                System.out.println("Neplatny vstup, skus znova: ");
                scanner.nextLine();
            }


        }

        Clazz chosenClazz = classes.get(choice - 1);


        for (Student student : chosenClazz.getStudents()) {
            int sum = 0;
            int count = 0;
            for (Integer grades : student.getSubjects().values()) {
                sum += grades;
                count++;
            }
            student_grade.put(student.getName(), (double) sum / count);
        }


        student_grade.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }

    public void addStudentInteractive() {
        System.out.println("Kde chces pridat studenta? ");
        int i = 1;
        for (Clazz clazz : classes) {
            System.out.println(i + ". " + clazz.getName());
            i++;
        }
        int choice;
        System.out.println("\nVyber triedu: ");
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice <= classes.size() && choice > 0) {
                    break;

                } else {
                    System.out.println("Zadaj existujucu triedu: ");
                }
            } else {
                System.out.println("neplatny vstup, skus este raz: ");
                scanner.nextLine();
            }

        }

        Clazz chosenClazz = classes.get(choice - 1);


        HashMap<Subject, Integer> subjectGrade = new HashMap<>();
        System.out.println("Zadaj meno studenta:");
        String name = scanner.next();


        for (Subject subject : chosenClazz.getSubjects()) {
            System.out.println("Zadaj znamku pre predmet '" + subject.name() + "' : ");
            int grade;
            while (true) {
                if (scanner.hasNextInt()) {
                    grade = scanner.nextInt();
                    scanner.nextLine();
                    if (grade > 0 && grade <= 5) {
                        break;
                    } else {
                        System.out.println("Zadaj znamku len od 1 do 5: ");
                    }
                } else {
                    System.out.println("Nespravny vstup, skus este raz: ");
                    scanner.nextLine();
                }
            }


            subjectGrade.put(subject, grade);

        }


        chosenClazz.addStudent(new Student(chosenClazz.getName(), name, subjectGrade));
        System.out.println("Student uspesne pridany do triedy " + chosenClazz.getName());


    }


}
