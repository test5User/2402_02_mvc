<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String potato = "I am potato!!!";
    int number = 26;
%>
<%! int square(int n) {
        return n*n;
    }
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2><%= potato + "!!!" %></h2>
    <p>Today <%= new java.util.Date()%></p>
    <p>5 в квадрате это <%= square(6) %></p>
</body>
</html>
