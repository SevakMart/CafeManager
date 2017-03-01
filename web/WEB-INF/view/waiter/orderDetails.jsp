<%--
  Created by IntelliJ IDEA.
  User: forjava
  Date: 2/26/2017
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>order details</title>
</head>
<body>
<h3>details for order number ${order.id}</h3>
<h2>products in order</h2>
<table>
    <tr>
        <td>product name</td>
        <td>price</td>
        <td>amount</td>
    </tr>
    <c:forEach items="${order.productInOrderList}" var="productInOrder">
        <td>${productInOrder.product.title}</td>
        <td>${productInOrder.product.price}</td>
        <td>${productInOrder.amount}</td>
    </c:forEach>
</table>
<a href="/table/showOrders/${order.table.id}">back to order list</a>
</body>
</html>
