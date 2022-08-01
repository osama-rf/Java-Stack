<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>User</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><c:out value="${item.name}" /></td>
                <td><c:out value="${item.description}" /></td>
                <td><c:out value="${item.price}" /></td>
                <td><c:out value="${item.user.fName} ${item.user.lName}" /></td>
                <td><form action="/delete/${item.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form></td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Items</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.fName} " /><c:out value="${user.lName}" /></td>
                <td><c:out value="${user.age}" /></td>
                <td>
                    <c:forEach var="item" items="${user.items}">
                        <c:out value="${item.name} " />
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>