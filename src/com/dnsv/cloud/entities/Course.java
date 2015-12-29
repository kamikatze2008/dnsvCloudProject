package com.dnsv.cloud.entities;

import java.util.ArrayList;

public class Course {
    int id;
    User teacher;
    String courseName;
    String day;
    int lectionNumber;

    public Course(int id, User teacher, String courseName, String day, int lectionNumber) {
        this.id = id;
        this.teacher = teacher;
        this.courseName = courseName;
        this.day = day;
        this.lectionNumber = lectionNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getLectionNumber() {
        return lectionNumber;
    }

    public void setLectionNumber(int lectionNumber) {
        this.lectionNumber = lectionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (getId() != course.getId()) return false;
        if (getLectionNumber() != course.getLectionNumber()) return false;
        if (!getTeacher().equals(course.getTeacher())) return false;
        if (!getCourseName().equals(course.getCourseName())) return false;
        return getDay().equals(course.getDay());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTeacher().hashCode();
        result = 31 * result + getCourseName().hashCode();
        result = 31 * result + getDay().hashCode();
        result = 31 * result + getLectionNumber();
        return result;
    }
}
