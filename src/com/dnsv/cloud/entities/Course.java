package com.dnsv.cloud.entities;

import java.util.ArrayList;

public class Course {
    int id;
    ArrayList<User> users;
    String courseName;
    String day;
    int lectionNumber;

    public Course(int id, ArrayList<User> users, String courseName, String day, int lectionNumber) {
        this.id = id;
        this.users = users;
        this.courseName = courseName;
        this.day = day;
        this.lectionNumber = lectionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (lectionNumber != course.lectionNumber) return false;
        if (!users.equals(course.users)) return false;
        if (!courseName.equals(course.courseName)) return false;
        return day.equals(course.day);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + users.hashCode();
        result = 31 * result + courseName.hashCode();
        result = 31 * result + day.hashCode();
        result = 31 * result + lectionNumber;
        return result;
    }
}
