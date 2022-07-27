<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">

<head>
    <title>Read Share</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.0-beta1 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
          crossorigin="anonymous">

</head>

<body>
<h1>Language</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Expense</th>
        <th scope="col">Vendor</th>
        <th scope="col">Amount</th>
        <th scope="col">Action</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${languages}">
        <tr>
            <td> <a href="/dashboard/show/${x.id}"><c:out value="${x.languageName}" /></a></td>
            <td><c:out value="${x.creator}" /></td>
            <td><c:out value="${x.currentVersion}" /></td>
            <td><a href="/dashboard/${x.id}/edit">edit</a></td>
            <td>
                <form action="/delete/${x.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>


<h1>Add Language</h1>
<form:form action="/dashboard" method="post" modelAttribute="languages">
    <p>
        <form:label path="languageName">Expense Name: </form:label>
        <form:errors path="languageName" />
        <form:input path="languageName" />
    </p>
    <p>
        <form:label path="creator">Vendor:</form:label>
        <form:errors path="creator" />
        <form:input path="creator" />
    </p>
    <p>
        <form:label path="currentVersion">Amount: </form:label>
        <form:errors path="currentVersion" />
        <form:input type="currentVersion" path="currentVersion" />
    </p>
    <input type="submit" value="Submit" />
</form:form>

<!-- Bootstrap JavaScript Libraries -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
        crossorigin="anonymous"></script>
</body>

</html>