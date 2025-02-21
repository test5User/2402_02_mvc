<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users info:</h1>
<c:choose>
    <c:when test="${not empty users}">
        <c:forEach var="user" items="${users}">
            <p>Id: ${user.id}, FIO: ${user.fio}, Email: ${user.email}</p>
        </c:forEach>
    </c:when>
    <c:otherwise>
        ${message}
    </c:otherwise>
</c:choose>
</body>
</html>