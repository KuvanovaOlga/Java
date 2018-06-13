<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <!--информация о выполняемом цикле и его текущем шаге-->
    <c:forEach var="elem" items="${lst}" varStatus="status">
        <tr>
            <td><c:out value="${elem}"/></td>
            <td><c:out value="${elem.id}"/></td>
            <td><c:out value="${elem.mess}"/></td>
            <td><c:out value="${status.count}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
