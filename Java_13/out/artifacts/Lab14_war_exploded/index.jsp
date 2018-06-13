<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="myTags.tld" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="JSTLcore.jsp">
    <input type="submit" value="Core">
  </form>
  <form action="ServletMess">
    <input type="submit" value="foreach">
  </form>
  <form action="formatting.jsp">
    <input type="submit" value="formatting">
  </form>
  <form action="sql.jsp">
    <input type="submit" value="sql">
  </form>
  <form action="XML.jsp">
    <input type="submit" value="XML">
  </form>
  <form action="functions.jsp">
    <input type="submit" value="Functions">
  </form>
  <form action="Result.jsp" method="post">
    <my:RAALabledTextField label="Name: " name="Firstname"/><br/>
    <my:RAALabledTextField label="Surname: " name="Surname"/><br/>
    <my:RAALabledTextField label="Fathername: " name="FatherName"/><br/>
    <my:RAALabledTextField label="City: " name="City"/><br/>
    <my:RAALabledTextField label="Street: " name="Street"/><br/><br/>
    <my:RAASubmit/>
  </form>
  </body>
</html>
