<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Func</title>
</head>
<body>
<c:set var="string" value="hello my dear friends 258"/>

<c:if test="${fn:contains(string, 'my')}">
    string contains my
</c:if>
<br>
<c:if test="${fn:contains(string, 'MY')}">
    string contains MY
</c:if>
<br>
<c:if test = "${fn:containsIgnoreCase(string, 'MY')}">
    string contains MY(IgnoreCase)<br/>
</c:if>
<h3>***********</h3>
<c:if test = "${fn:endsWith(string, '258')}">
    String ends with 258<br/>
</c:if>
<h3>***********</h3>
<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "This <abc>is second String.</abc>"/>
Index (1) : ${fn:indexOf(string1, "first")}<br/>
Index (2) : ${fn:indexOf(string2, "second")}<br/>
<h3>***********</h3>
<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:split(string1, ' ')}" />
<c:set var = "string3" value = "${fn:join(string2, '-')}" />
${string3}<br/>
<h3>***********</h3>
<c:set var = "string1" value = "This is first String."/>
Length of String1 : ${fn:length(string1)}<br/>
<h3>***********</h3>
<c:set var = "string1" value = "This is first String."/>
<c:set var = "string2" value = "${fn:replace(string1, 'first', 'second')}" />
${string2}<br>
</body>
</html>
