

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
    <h1>Item Form</h1>
    <form:form action="/item" method="post" modelAttribute="item">
        <p>
            <form:label path="user">User: </form:label>
            <form:select path="user">
                <c:forEach var="user" items="${users}">
                    <form:option value="${user}">
                        <c:out value="${user.fName}" />
                    </form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name" />
            <form:input path="name" />
        </p>
        <p>
            <form:label path="description">Description: </form:label>
            <form:errors path="description" />
            <form:input path="description" />
        </p>
        <p>
            <form:label path="price">Price: </form:label>
            <form:errors path="price" />
            <form:input path="price" />
        </p>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>