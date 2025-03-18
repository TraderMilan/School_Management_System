package org.example.classes.entities;

import java.util.List;

public class Teacher {
    private List<Subject> subject;
    private String clazzName;

    public Teacher(List<Subject> subject) {
        this.clazzName = " ";
        this.subject = subject;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName){
        this.clazzName = clazzName;
    }

    public List<Subject> getSubject() {
        return subject;
    }
}
