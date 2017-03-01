<%--
  Created by IntelliJ IDEA.
  User: forjava
  Date: 2/25/2017
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>assign to waiter</title>
</head>
<body>
<h3>assign table to waiters</h3>
<c:if test="${message!=null}">
    <h4 style="color: green;">${message}</h4>
</c:if>
<form:form action="/table/assignTo">
    <select name="waiterId">
        <c:forEach items="${users}" var="waiter">
            <option value="${waiter.id}">${waiter.userName}</option>
        </c:forEach>
    </select>

    <select name="tableId">
        <c:forEach items="${tables}" var="table">
            <option value="${table.id}">${table.tableNumber}</option>
        </c:forEach>
    </select>
    <input type="submit" value="assign">
</form:form>
<a href="/manager.html">back to manager page</a>

</body>
</html>
