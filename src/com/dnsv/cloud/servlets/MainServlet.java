package com.dnsv.cloud.servlets;

import com.dnsv.cloud.entities.User;
import com.google.appengine.api.utils.SystemProperty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    public static final String SUBMIT = "submit";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    public static final String LOGOUT = "logout";

    public static final String TEACHER = "teacher";
    public static final String STUDENT = "student";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PASS = "password";
    public static final String ENTITY = "entity";
    public static final String SCHEDULE = "schedule";
    public static final String CONF_PASS = "confirm";
    public static final String SECRET_WORD = "secret";
    public static final String SECRET_STRING = "dnsv";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequests(request, response);
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequests(request, response);
        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }

    private void processRequests(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String submitString = request.getParameter(SUBMIT);
        String dispatcherUrl;
        switch (submitString) {
            case LOGIN:
                dispatcherUrl = loginBehavior(request, response);
                break;
            case REGISTER:
                dispatcherUrl = registerBehavior(request, response);
                break;
            case LOGOUT:
                request.getSession().invalidate();
                dispatcherUrl = "/index.jsp";
                break;
            default:
                createMaths(request, response, submitString);
                request.getSession().setAttribute(SCHEDULE, getSchedule());
                dispatcherUrl = "/schedule.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(dispatcherUrl);
        requestDispatcher.forward(request, response);
    }

    private void createMaths(HttpServletRequest request, HttpServletResponse response, String lesson) throws Exception {
        HttpSession session = request.getSession();
        int teacherId = (Integer) session.getAttribute(ID);
        String dayOfWeek = lesson.substring(0, lesson.length() - 1);
        int numberOfLection = Integer.parseInt(lesson.substring(lesson.length() - 1, lesson.length()));
        String statement = "INSERT INTO courses (teacher, coursename, day_of_week, number_of_lection) VALUES (?,?,?,?)";
        Connection connection = getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, teacherId);
        preparedStatement.setString(2, "maths");
        preparedStatement.setString(3, dayOfWeek);
        preparedStatement.setInt(4, numberOfLection);
        preparedStatement.executeUpdate();
        connection.close();
    }

    private String loginBehavior(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dispatcherUrl;
        String name = request.getParameter(NAME);
        String password = request.getParameter(PASS);
        User user = checkCredentials(name, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(NAME, name);
            session.setAttribute(PASS, password);
            session.setAttribute(ID, user.getId());
            session.setAttribute(ENTITY, user.getEntity().toString());
            session.setAttribute(SCHEDULE, getSchedule());
            dispatcherUrl = "/schedule.jsp";
        } else {
            dispatcherUrl = "/index.jsp";
        }
        return dispatcherUrl;
    }

    private String registerBehavior(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dispatcherUrl;
        String name = request.getParameter(NAME);
        String password = request.getParameter(PASS);
        String confirm = request.getParameter(CONF_PASS);
        String secretWord = request.getParameter(SECRET_WORD);
        if (!"".equals(name) && !"".equals(password) && password.equals(confirm)) {
            if (SECRET_STRING.equals(secretWord)) {
                doInsertInUserTable(name, password, TEACHER);
            } else {
                doInsertInUserTable(name, password, STUDENT);
            }
            request.setAttribute(NAME, name);
            request.setAttribute(PASS, password);
            request.setAttribute("registered", true);
            dispatcherUrl = "/index.jsp";

        } else {
            dispatcherUrl = "/registration.jsp";
        }
        return dispatcherUrl;
    }

    public static Connection getDbConnection() throws IOException, ClassNotFoundException, SQLException {
        String url;
        if (SystemProperty.environment.value() ==
                SystemProperty.Environment.Value.Production) {
            Class.forName("com.mysql.jdbc.GoogleDriver");
            url = "jdbc:google:mysql://dnsvcloudproject:dnsvcloudproject/dnsvDb?user=root";
        } else {
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://127.0.0.1:3306/dnsvDb?user=root";
        }
        return DriverManager.getConnection(url);
    }

    private void doInsertInUserTable(String name, String password, String type) throws IOException, SQLException, ClassNotFoundException {
        Connection connection = getDbConnection();
        String statement = "INSERT INTO users (username, userpass, entity) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, type);
        preparedStatement.executeUpdate();
        connection.close();
    }

    private User checkCredentials(String name, String password) throws IOException, SQLException, ClassNotFoundException {
        Connection connection = getDbConnection();
        User user = null;
        String statement = "SELECT * FROM users WHERE username=? AND userpass=?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nameDb = resultSet.getString(resultSet.findColumn("username"));
            String passDb = resultSet.getString(resultSet.findColumn("userpass"));
            String entity = resultSet.getString(resultSet.findColumn("entity"));
            if (nameDb != null && passDb != null) {
                if ("teacher".equals(entity)) {
                    user = new User(id, nameDb, passDb, User.Entity.TEACHER);
                } else {
                    user = new User(id, nameDb, passDb, User.Entity.STUDENT);
                }
            }
        }
        connection.close();
        return user;
    }

    protected Map<String, String> getSchedule() throws IOException, SQLException, ClassNotFoundException {
        Connection connection = getDbConnection();
        Map<String, String> schedule = new HashMap<>();
        String statement = "SELECT * FROM courses";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String courseName = resultSet.getString(resultSet.findColumn("coursename"));
            String dayOfWeek = resultSet.getString(resultSet.findColumn("day_of_week"));
            int lectureNumber = resultSet.getInt(resultSet.findColumn("number_of_lection"));
            int teacherId = resultSet.getInt(resultSet.findColumn("teacher"));
            schedule.put(dayOfWeek + lectureNumber, courseName);
        }
        connection.close();
        return schedule;
    }

    public static User getTeacher(Connection connection, int teacherId) throws IOException, SQLException, ClassNotFoundException {
        User teacher = null;
        String statement = "SELECT * FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        preparedStatement.setInt(1, teacherId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String nameDb = resultSet.getString(resultSet.findColumn("username"));
            String passDb = resultSet.getString(resultSet.findColumn("userpass"));
            teacher = new User(id, nameDb, passDb, User.Entity.TEACHER);
        }
        return teacher;
    }
}
