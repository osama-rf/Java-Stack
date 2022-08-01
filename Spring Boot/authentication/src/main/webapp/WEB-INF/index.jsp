<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login and Registration</title>
</head>
<body>
<form:form action="/register" method="post" modelAttribute="newUser">
    <div class="form-group">
        <label>User Name:</label>
        <form:input path="userName" class="form-control" />
        <form:errors path="userName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Email:</label>
        <form:input path="email" class="form-control" />
        <form:errors path="email" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Password:</label>
        <form:password path="password" class="form-control" />
        <form:errors path="password" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Confirm Password:</label>
        <form:password path="confirm" class="form-control" />
        <form:errors path="confirm" class="text-danger" />
    </div>
    <input type="submit" value="Register" class="btn btn-primary" />
</form:form>

<form:form action="/login" method="post" modelAttribute="newLogin">
    <div class="form-group">
        <label>Email:</label>
        <form:input path="email" class="form-control" />
        <form:errors path="email" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Password:</label>
        <form:password path="password" class="form-control" />
        <form:errors path="password" class="text-danger" />
    </div>
    <input type="submit" value="Login" class="btn btn-success" />
</form:form>
</body>
</html>