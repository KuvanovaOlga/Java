<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XML</title>
</head>
<body>
<c:import var="booksInformation" url="books.xml"/>
<!--парсинг-->
<x:parse xml="${booksInformation}" var="info"/>
first book :
<x:out select="$info/books/book[1]/name"/><br>
second book :
<x:out select="$info/books/book[2]/name"/><br>
<h1>------------</h1>
<x:choose>
    <x:when select="$info/books/book[1]/author = 'J.K.Rowling'">
        book is writen by J.K.Rowling
    </x:when>
    <x:otherwise>
        Unknown author
    </x:otherwise>
</x:choose>
<h1>-----------------</h1>
<c:import url="stule.xsl" var="style"/>
<x:transform xml="${info}" xslt="${style}"/>
</body>
</html>
