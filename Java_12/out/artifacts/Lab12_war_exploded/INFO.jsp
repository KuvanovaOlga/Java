<%--
  Created by IntelliJ IDEA.
  User: rabts
  Date: 11.05.2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="Header.jsp"%><br>
<body>
<form action="info">
    <label>Enter your Name</label><br>
    <input type="text" name="Name" value="${param.Name}"><br>
    <label>Enter your Surname</label><br/>
    <input type="text" name="Surname" value="${param.Surname}"><br/>
    <input type="submit" value="->">
</form>
<form action="Welcome.jsp">
    <input type="submit" value="<-">
</form>
</body>
<%@include file="Footer.jsp"%><br>
</html>
