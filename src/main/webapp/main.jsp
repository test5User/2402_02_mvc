<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<String> words = List.of("One", "Two", "Three");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    Объявить переменную--%>
    <c:set var="number" value="26" scope="page"/>
<%--    Получаем объявленную переменную--%>
    <p>Our variable is ${number}</p>
    <p>Sum our var and 15 is ${number + 15}</p>
<%--    Удалить переменную--%>
    <c:remove var="number"/>
    <p>Our variable is ${number}</p>
<%--    Простой оператор выбора--%>
    <c:if test="${empty number}">
        <p>Our variable is not exist or null</p>
    </c:if>
<%--    Сложный оператор выбора--%>
    <c:set var="number" value="5" scope="page"/>
    <c:choose>
        <c:when test="${number > 10}">
            <p>Number is more than 10</p>
        </c:when>
        <c:when test="${number < 10}">
            <p>Number is less than 10</p>
        </c:when>
        <c:otherwise>
            <p>Number is equals 10</p>
        </c:otherwise>
    </c:choose>
<%--    Оператор url--%>
    <c:url var="link" value="https://google.com"/>
    <p>
        This is the <a href="${link}">link</a> on the page.
    </p>

    <c:url var="link" value="https://google.com/search">
        <c:param name="q" value="cats"/>
    </c:url>
    <p>
        <a href="${link}">Cats </a> form google.
    </p>
<%--    Оператор цикла--%>
    <ol>
        <c:forEach var="word" items="<%=words%>">
            <li>
                <c:out value="${word}"/>
            </li>
        </c:forEach>
    </ol>
</body>
</html>
