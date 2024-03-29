package com.brightflag.domain;

/**
 * 'Joining' class that handles student subject enrollments
 */
public class Student_Subject {

    private Integer student;
    private Integer subject;

    public Student_Subject(){

    }

    public Student_Subject(Integer student, Integer subject) {
        this.student = student;
        this.subject = subject;
    }

    //Getters and setters
    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

}
