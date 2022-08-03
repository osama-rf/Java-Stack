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
    <title>New Category</title>
</head>
<body>
<form:form action="/category/new" method="POST" modelAttribute="Category">
    <p>
        <form:label path="name">Name: </form:label>
        <form:input path="name" />
        <input type="submit" value="Submit" />
    </p>
</form:form>
</body>
</html>
