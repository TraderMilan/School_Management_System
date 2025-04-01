package org.example.classes.entities;

import java.util.*;

public class Clazz {

    private final String name;
    private List<Student> students;
    private final Teacher headTeacher;
    private final List<Subject> subjects;

    public Clazz(String ID, List<Student> students, Teacher headTeacher, List<Subject> subjects) {
        this.name = ID;
        this.students = students;
        this.headTeacher = headTeacher;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void updateHeadTeacher(String clazzName){
        this.headTeacher.setClazzName(clazzName);
    }

    public void addStudent(Student student){
        students.add(student);
    }

}
