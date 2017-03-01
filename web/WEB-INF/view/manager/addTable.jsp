<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: forjava
  Date: 2/25/2017
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Table</title>
</head>
<body>
<div style="width: 30%">
    <h3>create tables</h3>
    <c:if test="${message!=null}">
        <h4 style="color: green;">${message}</h4>
    </c:if>
    <form:form action="/table/admin/create" method="post" commandName="table">
        <form:errors path="tableNumber" cssStyle="color: red"/> <br>
        <form:input path="tableNumber" type="number" placeholder="number of table"/> <br> <br>
        <input type="submit" value="create table">
    </form:form>
</div>
<a href="/manager.html">back to manager page</a
</body>
</html>
