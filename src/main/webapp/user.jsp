<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
  <h1>User info</h1>
  <c:choose>
    <c:when test="${not empty user}">
        <p>Id: ${user.id}</p>
        <p>FIO: ${user.fio}</p>
        <p>Email: ${user.email}</p>
    </c:when>
    <c:otherwise>
        ${message}
    </c:otherwise>
  </c:choose>
</body>
</html>
