<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <!doctype html>
                <html lang="en">

                <head>
                    <title>Dashboard</title>
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
                    <div class="container d-flex justify-content-between w-50">
                        <h1>Welcome
                            <c:out value="${book.userName}" />
                        </h1>
                        <a href="/logout">logout</a>
                    </div>

                    <div class="container d-flex justify-content-between w-50">
                        <p>Books from everyone's shelves:</p>
                        <a href="/book/add"> add a book to my shelf</a>
                    </div>

                    <div class="container d-flex justify-content-between w-50">
                        <table class="table ">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Title</th>
                                    <th scope="col">Author Name:</th>
                                    <th scope="col">Posted By</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var = "book" items = "${books}">
                                <tr>
                                    <th scope="row">${book.id}</th>
                                    <td><a href="book/${book.id}">${book.title}</a></td>
                                    <td>${book.author}</td>
                                    <td>${book.creator.userName}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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