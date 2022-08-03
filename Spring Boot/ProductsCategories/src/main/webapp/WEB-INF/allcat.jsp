<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>All Category</title>
</head>
<body>
<h1>${category.name}</h1>
<h3>Products</h3>
<ul>
    <c:forEach var="pro" items="${category.products}">
        <li>${pro.name}</li>
    </c:forEach>
</ul>

<form action="/category/${category.id}/addproduct" method="post">
    <select name="product">
        <c:forEach var="prod" items="${products}">
            <option value="${prod.id}">${prod.name}</option>
        </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>