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
<form action="Welcome.jsp">
    <label>Enter your E-mail</label><br/>
    <input type="text" name="Email" value="${param.Email}"><br/>
    <input type="submit" value="->">
</form>
<form action="Adress.jsp">
    <input type="text" name="City" value="${param.City}"><br>
    <input type="submit" value="<-">
</form>
</body>
<%@include file="Footer.jsp"%><br>
</html>
