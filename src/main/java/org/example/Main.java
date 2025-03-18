package org.example;

import org.example.classes.entities.Clazz;
import org.example.classes.entities.Student;
import org.example.classes.entities.Subject;
import org.example.classes.entities.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Subject> subjects_5A = new ArrayList<>();
        subjects_5A.add(Subject.ACCOUNTING);
        subjects_5A.add(Subject.CHEMISTRY);
        subjects_5A.add(Subject.MATHEMATICS);

        Teacher headTeacher_5A = new Teacher(subjects_5A);

        Clazz clazz_5A = new Clazz("5A", new ArrayList<>(), headTeacher_5A, subjects_5A);
        clazz_5A.updateHeadTeacher(clazz_5A.getName());


        List<Subject> subjects_5B = new ArrayList<>();
        subjects_5B.add(Subject.ENGLISH);
        subjects_5B.add(Subject.PHYSICAL_EDUCATION);
        subjects_5B.add(Subject.PHYSICS);
        subjects_5B.add(Subject.MATHEMATICS);

        Teacher headTeacher_5B = new Teacher(subjects_5B);

        Clazz clazz_5B = new Clazz("5B", new ArrayList<>(), headTeacher_5B, subjects_5B);
        clazz_5B.updateHeadTeacher(clazz_5B.getName());


        List<Subject> subjects_5C = new ArrayList<>();
        subjects_5C.add(Subject.CHEMISTRY);
        subjects_5C.add(Subject.PHYSICAL_EDUCATION);
        subjects_5C.add(Subject.ACCOUNTING);
        subjects_5C.add(Subject.ENGLISH);

        Teacher headTeacher_5C = new Teacher(subjects_5C);

        Clazz clazz_5C = new Clazz("5C", new ArrayList<>(), headTeacher_5C, subjects_5C);
        clazz_5C.updateHeadTeacher(clazz_5C.getName());

        List<Clazz> classes = new ArrayList<>();
        classes.add(clazz_5A);
        classes.add(clazz_5B);
        classes.add(clazz_5C);

        HashMap<Subject, Integer> students_5A = new HashMap<>();
        for (Subject subject : clazz_5A.getSubjects()) {
            int random = (int) (Math.random() * 5) + 1;
            students_5A.put(subject, random);
        }
        Student student1 = new Student(clazz_5A.getName(), "Milos", students_5A);
        Student student2 = new Student(clazz_5A.getName(), "Adam", students_5A);
        Student student3 = new Student(clazz_5A.getName(), "Jordan", students_5A);
        clazz_5A.addStudent(student1);
        clazz_5A.addStudent(student2);
        clazz_5A.addStudent(student3);


        HashMap<Subject, Integer> students_5B = new HashMap<>();
        for (Subject subject : clazz_5B.getSubjects()) {
            int random = (int) (Math.random() * 5) + 1;
            students_5B.put(subject, random);
        }
        Student student1_5B = new Student(clazz_5B.getName(), "Milos", students_5B);
        Student student2_5B = new Student(clazz_5B.getName(), "Adam", students_5B);
        Student student3_5B = new Student(clazz_5B.getName(), "Jordan", students_5B);
        clazz_5B.addStudent(student1_5B);
        clazz_5B.addStudent(student2_5B);
        clazz_5B.addStudent(student3_5B);


        HashMap<Subject, Integer> students_5C = new HashMap<>();
        for (Subject subject : clazz_5C.getSubjects()) {
            int random = (int) (Math.random() * 5) + 1;
            students_5C.put(subject, random);
        }
        Student student1_5C = new Student(clazz_5C.getName(), "Milos", students_5C);
        Student student2_5C = new Student(clazz_5C.getName(), "Adam", students_5C);
        Student student3_5C = new Student(clazz_5C.getName(), "Jordan", students_5C);
        clazz_5C.addStudent(student1_5C);
        clazz_5C.addStudent(student2_5C);
        clazz_5C.addStudent(student3_5C);

        School school = new School(classes);

        System.out.println("\n--- Vitaj v mojej skole ---");
        while (true) {

            System.out.println("\n0. Koniec");
            System.out.println("1. Pridaj studenta");
            System.out.println("2. Vytlac studentov podla priemernych znamok");
            System.out.println("3. Vytlac predmet podla najlepsich znamok");
            System.out.println("4. Vytlac triedy podla najlepsich znamok");
            System.out.println("--- Zadaj prikaz:  ");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Nespravny prikaz, skus znovu:");
                    scanner.nextLine();
                }

            }


            switch (choice) {
                case 0 -> {
                    System.out.println("\n --- Dovidenia ---");
                    return;
                }
                case 1 -> school.addStudentInteractive();
                case 2 -> school.printStudentsByAvgGrade();
                case 3 -> school.printSubjectByBestGrade(school);
                case 4 -> school.printSortedClassesByBestAvgGrades(school);
                default -> {
                    System.out.println("neexistujuci prikaz, skus znovu: ");
                    scanner.nextLine();
                }
            }

        }

    }
}