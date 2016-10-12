package com.example.lesson1_retofit.bean;

/**
 * Created by hengyilin on 16-10-5.
 */

public class Student {
    private String name;
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
