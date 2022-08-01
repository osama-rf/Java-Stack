

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>New User</h1>
    <form:form action="/user" method="post" modelAttribute="user">
        <p>
            <form:label path="fName">First Name</form:label>
            <form:errors path="fName" />
            <form:input path="fName" />
        </p>
        <p>
            <form:label path="lName">Last Name: </form:label>
            <form:errors path="lName" />
            <form:input path="lName" />
        </p>
        <p>
            <form:label path="age">Age: </form:label>
            <form:errors path="age" />
            <form:input path="age" />
        </p>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>