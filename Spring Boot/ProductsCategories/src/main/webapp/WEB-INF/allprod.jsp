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
    <title>All Product</title>
</head>
<body>
<h1>${product.name}</h1>
<h3>Category</h3>
<ul>
    <c:forEach var="cat" items="${product.categories}">
        <li>${cat.name}</li>
    </c:forEach>
</ul>

<form action="/product/${product.id}/addcategory" method="post">
    <select name="category">
        <c:forEach var="cats" items="${category}">
            <option value="${cats.id}">${cats.name}</option>
        </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>