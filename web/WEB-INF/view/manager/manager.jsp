<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: forjava
  Date: 2/25/2017
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager page</title>
</head>
<body>

<h2>Welcome ${sessionScope.user.userName}</h2>
<h3>choose the option you want</h3>
<div>
    <ul>
        <li><a href="/admin/showUser">add waiter</a></li>
        <li><a href="/admin/showProduct">add product</a></li>
        <li><a href="/admin/showTable">add table</a></li>
        <li><a href="/admin/showAssignTo">assign table to waiter</a></li>
        <li><a href="/logout">log out</a></li>
    </ul>
</div>
</body>
</html>
