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
    <title>Welcome</title>
</head>
<%@include file="Header.jsp"%><br>
<body>
<H4>${Welcome}</H4><br>
<form action="INFO.jsp">
    <input type="submit" value="Add Information">
</form>
</body>
<%@include file="Footer.jsp"%><br>
</html>
