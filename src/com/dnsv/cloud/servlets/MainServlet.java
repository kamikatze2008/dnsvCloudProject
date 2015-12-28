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

public class MainServlet extends HttpServlet {
    private static final String SUBMIT = "submit";
    private static final String LOGIN = "login";
    private static final String REGISTER = "register";
    private static final String LOGOUT = "logout";

    private static final String TEACHER = "teacher";
    private static final String STUDENT = "student";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PASS = "password";
    private static final String CONF_PASS = "confirm";
    private static final String SECRET_WORD = "secret";
    private static final String SECRET_STRING = "dnsv";

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
        String dispatcherUrl = null;
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
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(dispatcherUrl);
        requestDispatcher.forward(request, response);
    }

    private String loginBehavior(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String dispatcherUrl;
        String name = request.getParameter(NAME);
        String password = request.getParameter(PASS);
        User user = checkCredentials(name, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute(NAME, name);
            session.setAttribute(ID, user.getId());
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

    private Connection getDbConnection() throws IOException, ClassNotFoundException, SQLException {
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
}
