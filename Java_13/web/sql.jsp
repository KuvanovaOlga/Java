
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource  driver="net.sourceforge.jtds.jdbc.Driver" url="jdbc:jtds:sqlserver://localhost:1433;databaseName=Timetable of classes" user="User" password="1"/>
<sql:transaction>
    <sql:update>
        insert into Teachers(nameSurname, subject,lectureCount, studentsCount) values('gfgd', 'nbmbm', 14, 144);
    </sql:update>
</sql:transaction>
<sql:query var="selectedRows" sql="select subject from Teachers where lectureCount = 1"></sql:query>

<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>subject</td>
    </tr>
    <c:forEach var="currentRow" items="${selectedRows.rows}">
        <tr>
            <td><c:out value="${currentRow.subject}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
