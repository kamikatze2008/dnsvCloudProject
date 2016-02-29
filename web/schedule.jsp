<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Schedule</title>
</head>
<body>
<h1>Schedule</h1>
<h2>Welcome, <c:out value="${sessionScope.name}"/>!</h2>
<table border="5">
    <tr>
        <td></td>
        <td>Monday</td>
        <td>Tuesday</td>
        <td>Wednesday</td>
        <td>Thursday</td>
        <td>Friday</td>
        <td>Saturday</td>
    </tr>
    <tr>
        <td>Lecture 1</td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Monday1']}">
                    ${sessionScope.schedule['Monday1']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Monday1">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
            <c:when test="${not empty sessionScope.schedule['Tuesday1']}">
                ${sessionScope.schedule['Tuesday1']}
            </c:when>
            <c:when test="${sessionScope.entity eq 'TEACHER'}">
            <form action="/MainServlet" method="get">
                <button type="submit" name="submit" value="Tuesday1">Create Maths lecture</button>
            </form>
            </c:when>
            </c:choose>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Wednesday1']}">
                    ${sessionScope.schedule['Wednesday1']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Wednesday1">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Thursday1']}">
                    ${sessionScope.schedule['Thursday1']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Thursday1">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Friday1']}">
                    ${sessionScope.schedule['Friday1']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Friday1">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Saturday1']}">
                    ${sessionScope.schedule['Saturday1']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Saturday1">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>Lecture 2</td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Monday2']}">
                    ${sessionScope.schedule['Monday2']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Monday2">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
            <c:when test="${not empty sessionScope.schedule['Tuesday2']}">
                ${sessionScope.schedule['Tuesday2']}
            </c:when>
            <c:when test="${sessionScope.entity eq 'TEACHER'}">
            <form action="/MainServlet" method="get">
                <button type="submit" name="submit" value="Tuesday2">Create Maths lecture</button>
            </form>
            </c:when>
            </c:choose>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Wednesday2']}">
                    ${sessionScope.schedule['Wednesday2']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Wednesday2">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Thursday2']}">
                    ${sessionScope.schedule['Thursday2']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Thursday2">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Friday2']}">
                    ${sessionScope.schedule['Friday2']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Friday2">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Saturday2']}">
                    ${sessionScope.schedule['Saturday2']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Saturday2">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>Lecture 3</td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Monday3']}">
                    ${sessionScope.schedule['Monday3']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Monday3">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
            <c:when test="${not empty sessionScope.schedule['Tuesday3']}">
                ${sessionScope.schedule['Tuesday3']}
            </c:when>
            <c:when test="${sessionScope.entity eq 'TEACHER'}">
            <form action="/MainServlet" method="get">
                <button type="submit" name="submit" value="Tuesday3">Create Maths lecture</button>
            </form>
            </c:when>
            </c:choose>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Wednesday3']}">
                    ${sessionScope.schedule['Wednesday3']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Wednesday3">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Thursday3']}">
                    ${sessionScope.schedule['Thursday3']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Thursday3">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Friday3']}">
                    ${sessionScope.schedule['Friday3']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Friday3">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Saturday3']}">
                    ${sessionScope.schedule['Saturday3']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Saturday3">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>Lecture 4</td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Monday4']}">
                    ${sessionScope.schedule['Monday4']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Monday4">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
            <c:when test="${not empty sessionScope.schedule['Tuesday4']}">
                ${sessionScope.schedule['Tuesday4']}
            </c:when>
            <c:when test="${sessionScope.entity eq 'TEACHER'}">
            <form action="/MainServlet" method="get">
                <button type="submit" name="submit" value="Tuesday4">Create Maths lecture</button>
            </form>
            </c:when>
            </c:choose>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Wednesday4']}">
                    ${sessionScope.schedule['Wednesday4']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Wednesday4">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Thursday4']}">
                    ${sessionScope.schedule['Thursday4']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Thursday4">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Friday4']}">
                    ${sessionScope.schedule['Friday4']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Friday4">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Saturday4']}">
                    ${sessionScope.schedule['Saturday4']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Saturday4">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td>Lecture 5</td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Monday5']}">
                    ${sessionScope.schedule['Monday5']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Monday5">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
            <c:when test="${not empty sessionScope.schedule['Tuesday5']}">
                ${sessionScope.schedule['Tuesday5']}
            </c:when>
            <c:when test="${sessionScope.entity eq 'TEACHER'}">
            <form action="/MainServlet" method="get">
                <button type="submit" name="submit" value="Tuesday5">Create Maths lecture</button>
            </form>
            </c:when>
            </c:choose>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Wednesday5']}">
                    ${sessionScope.schedule['Wednesday5']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Wednesday5">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${not empty sessionScope.schedule['Thursday5']}">
                    ${sessionScope.schedule['Thursday5']}
                </c:when>
                <c:when test="${sessionScope.entity eq 'TEACHER'}">
                    <form action="/MainServlet" method="get">
                        <button type="submit" name="submit" value="Thursday5">Create Maths lecture</button>
                    </form>
                </c:when>
            </c:choose>
        </td>
        <form action="/MainServlet" method="get">
            <td>
                <c:choose>
                    <c:when test="${not empty sessionScope.schedule['Friday5']}">
                        ${sessionScope.schedule['Friday5']}
                    </c:when>
                    <c:when test="${sessionScope.entity eq 'TEACHER'}">
                        <button type="submit" name="submit" value="Friday5">Create Maths lecture</button>
                    </c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${not empty sessionScope.schedule['Saturday5']}">
                        ${sessionScope.schedule['Saturday5']}
                    </c:when>
                    <c:when test="${sessionScope.entity eq 'TEACHER'}">
                        <button type="submit" name="submit" value="Saturday5">Create Maths lecture</button>
                    </c:when>
                </c:choose>
            </td>
        </form>
    </tr>
</table>
<br/>
<form action="/MainServlet" method="get">
    <button type="submit" name="submit" value="logout">Log Out</button>
</form>
</body>
</html>
