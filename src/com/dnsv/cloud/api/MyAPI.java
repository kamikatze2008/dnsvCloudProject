package com.dnsv.cloud.api;

import com.dnsv.cloud.entities.Course;
import com.dnsv.cloud.servlets.MainServlet;
import com.google.api.server.spi.Constant;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Api(name = "dnsvCloud",
        version = "v1",
        clientIds = {"624544556573-men8nt6kr9jtik6oq15cj53bp2hieovq.apps.googleusercontent.com", Constant.API_EXPLORER_CLIENT_ID},
        audiences = {"624544556573-men8nt6kr9jtik6oq15cj53bp2hieovq.apps.googleusercontent.com"},
        description = "MyAPI")
public class MyAPI {
    @ApiMethod(name = "courses.show", path = "courses", httpMethod = ApiMethod.HttpMethod.GET)
    public ArrayList<Course> getCourses() throws Exception {
        Connection connection = MainServlet.getDbConnection();
        ArrayList<Course> courses = new ArrayList<>();
        String statement = "SELECT * FROM courses";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String courseName = resultSet.getString(resultSet.findColumn("coursename"));
            String dayOfWeek = resultSet.getString(resultSet.findColumn("day_of_week"));
            int lectureNumber = resultSet.getInt(resultSet.findColumn("number_of_lection"));
            int teacherId = resultSet.getInt(resultSet.findColumn("teacher"));
            Course course = new Course(id, MainServlet.getTeacher(connection, teacherId), courseName, dayOfWeek, lectureNumber);
            courses.add(course);
        }
        connection.close();
        return courses;
    }
}
