<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Core</title>
</head>
<body>
<!--создаем переменные-->
    <c:set var="user" value="admin" scope="page"/>
    <c:if test="${not empty user and user eq 'admin'}">
        Admin
    </c:if>
<!--удаляем переменные-->
    <c:remove var="user"/><br>
<h1>--------------</h1>
    <c:set var="a" value="228"/>
    <c:choose>
        <c:when test="${a lt 200}">
            <c:out value="less than 200"/>
        </c:when>
        <c:when test="${a gt 200}">
            <c:out value="more than 200"/>
        </c:when>
    </c:choose>
    <br>
<h1>----------------------</h1>
    <c:set var="zu" value="2.8" scope="session"/>
    <c:catch var="ex">
        <c:if test="${zu < 10}">
            <c:out value="Num ${zu}"/> less than 10
        </c:if>
    </c:catch>
    <br>
    <c:if test="${not empty ex}">
        Format exception in <c:out value="${zu}"/>
        <br>
        Exception: ${ex}
    </c:if>
<h1>----------------------</h1>
</body>
</html>
