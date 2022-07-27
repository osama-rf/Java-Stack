<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <!doctype html>
                <html lang="en">

                <head>
                    <title>Language</title>
                    <!-- Required meta tags -->
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

                    <!-- Bootstrap CSS v5.2.0-beta1 -->
                    <link rel="stylesheet"
                        href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
                        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
                        crossorigin="anonymous">

                </head>

                <body>
                
                    <div class="container w-50">
                        <h1>Language</h1>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Expense</th>
                            <th scope="col">Creator</th>
                            <th scope="col">Version</th>
                            <th scope="col">Action</th>
                            <th scope="col">Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="x" items="${languages}">
                            <tr>
                                <td> <a href="/dashboard/${x.id}"><c:out value="${x.name}" /></a></td>
                                <td><c:out value="${x.creator}" /></td>
                                <td><c:out value="${x.currentVersion}" /></td>
                                <td><a href="/dashboard/${x.id}/edit">Edit</a></td>
                                <td>
                                    <form action="/dashboard/${x.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="Delete">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <hr>
                    
                    <div class="container-fluid">
                        <c:if test="${!errors.isEmpty()}">
                            <c:forEach var = "error" items="${errors}" >
                                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    <strong>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-exclamation-triangle-fill" viewBox="0 0 16 16">
                                            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                        </svg>
                                    </strong>
                                    <span class="mx-4">
                                            <c:out value="${error.getDefaultMessage()}"/>
                                        </span>
                                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                </div>
                            </c:forEach>
                        </c:if>
                
                        <c:if test="${success != null}">
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <strong>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                        <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05z"/>
                                    </svg>
                                </strong>
                                <span class="mx-4">
                                            <c:out value="${success}"/>
                                        </span>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                    </div>
                    
                    <h1>Add Language</h1>
                    <form:form action="/dashboard" method="POST" modelAttribute="language">
                        <p>
                            <form:label path="name">Language Name: </form:label>
                            <form:input path="name" />
                        </p>
                        <p>
                            <form:label path="creator">Creator:</form:label>
                            <form:input path="creator" />
                        </p>
                        <p>
                            <form:label path="currentVersion">Version: </form:label>
                            <form:input type="currentVersion" path="currentVersion" />
                        </p>
                        <input type="submit" value="Submit" />
                    </form:form>
                    </div>
                
                    <!-- Bootstrap JavaScript Libraries -->
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
                        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
                        crossorigin="anonymous"></script>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
                        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
                        crossorigin="anonymous"></script>
                </body>

                </html>