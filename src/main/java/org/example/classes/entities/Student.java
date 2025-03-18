package org.example.classes.entities;

import java.util.HashMap;

public class Student {


    private String name;
    private HashMap<Subject, Integer> subjects;
    private String clazzName;


    public Student(String clazzName, String name, HashMap<Subject, Integer> subjects) {
        this.clazzName = clazzName;
        this.name = name;
        this.subjects = subjects;
    }

    public String getClazzName() {
        return clazzName;
    }

    public String getName() {
        return name;
    }

    public HashMap<Subject, Integer> getSubjects() {
        return subjects;
    }

}
