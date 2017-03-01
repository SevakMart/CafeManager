<%--
  Created by IntelliJ IDEA.
  User: forjava
  Date: 2/25/2017
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN PAGE</title>
</head>
<body>
<h3>${message}</h3>
<form action="/login" method="post">
    <input type="text" name="userName" placeholder="user name"><br> <br>
    <input type="password" name="password" placeholder="password"> <br> <br>
    <input type="submit" value="log in">
</form>
</body>
</html>
