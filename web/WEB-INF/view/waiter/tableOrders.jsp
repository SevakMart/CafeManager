<%--
  Created by IntelliJ IDEA.
  User: forjava
  Date: 2/26/2017
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color: green;">all orders for ${table.tableNumber} table</h3>
<c:if test="${message!=null}">
    <h2 style="color: green;">${message}</h2>
</c:if>
<table border="1">
    <tr>
        <td>order id</td>
        <td>order status</td>
        <td>add products in order</td>
        <td>cancel order</td>
        <td>close order</td>
        <td>order details</td>
    </tr>
    <c:forEach items="${table.orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.orderStatus}</td>
            <td><a href="/productInOrder/showPage/${order.table.id}/${order.id}">add products in order</a></td>
            <td><a href="/order/cancel/${order.id}">cancel order</a></td>
            <td><a href="/order/close/${order.id}">close order</a></td>
            <td><a href="/order/show/${order.id}">show details</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/waiter/showPage">back to table list</a>
</body>
</html>
