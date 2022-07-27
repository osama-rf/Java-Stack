<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Edit Item</h1>
    <form:form action="/item/${item.id}" method="post" modelAttribute="item">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name" />
            <form:input path="name" />
        </p>
        <p>
            <form:label path="description">Description:</form:label>
            <form:errors path="description" />
            <form:input path="description" />
        </p>
        <p>
            <form:label path="price">Price:</form:label>
            <form:errors path="price" />
            <form:input path="price" />
        </p>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>