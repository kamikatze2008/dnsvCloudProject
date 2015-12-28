<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration screen</h1>
<form action="${pageContext.request.contextPath}/MainServlet" method="get">
    Enter name:<br/>
    <input title="name" name="name" type="text"><br/>
    Enter password:<br/>
    <input title="password" name="password" type="password"><br/>
    Confirm password:<br/>
    <input title="confirm_password" name="confirm" type="password"><br/>
    Secret word (necessary if you're teacher):<br/>
    <input title="secret_word" type="password"><br/>
    <button type="submit" name="submit" value="register">Log In</button>
</form>
<br/>
</body>
</html>
