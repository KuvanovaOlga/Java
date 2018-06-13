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
    <title>Lab12</title>
  </head>
  <%@include file="Header.jsp"%><br>
  <body>
  <form action="login">
    <label>Name</label><br>
    <input type="text" name="UsName"><br>
    <label>Password</label><br>
    <input type="text" name="UsPassword"><br>
    <input type="submit" value="LogIn">
  </form>
  </body>
  <%@include file="Footer.jsp"%><br>
</html>
