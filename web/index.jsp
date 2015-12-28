<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>dnsvCloudProject</title>
</head>
<body>
<h1>LogIn</h1>
<form action="${pageContext.request.contextPath}/MainServlet" method="get">
    <c:if test="${not empty registered}">
        You've just passed registration. <br/>
    </c:if>
    Enter name:<br/>
    <input title="Name" name="name" value="${name}" type="text"><br/>
    Enter password:<br/>
    <input title="Password" value="${password}" name="password" type="password"><br/><br/>
    <button type="submit" name="submit" value="login">Submit</button>
</form>
<a href="registration.jsp">Registration</a>
</body>
</html>
