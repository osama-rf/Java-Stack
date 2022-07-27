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
    <title>New Ninjas</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Select Dojo</form:label>
        <form:select path="dojo">
            <c:forEach var="d" items="${dojos}">
            <form:option value="${d.id}">
                <c:out value="${d.name}"/>
            </form:option>
            </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="firstName"> Ninja First Name: </form:label>
        <form:input path="firstName" />
    </p>
    <p>
        <form:label path="lastName">Ninja Last Name:</form:label>
        <form:input path="lastName" />
    </p>
    <p>
        <form:label path="age">Ninja Age: </form:label>
        <form:input type="number" path="age" />
    </p>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>