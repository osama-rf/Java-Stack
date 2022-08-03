<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <!doctype html>
                <html lang="en">

                <head>
                    <title>Title</title>
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
                    <div class="container pt-4 justify-content-between w-50">
                        <div class="d-flex justify-content-between ">
                            <h2>${book.title}</h2>
                            <a href="/book">back to the shelves</a>
                            <a href="/logout">logout</a>
                        </div>
                        <div class="container">
                            <c:if test="${book.user.id == user_id}">
                                <h4>You Read ${book.title} by ${book.author}</h4>
                            </c:if>
                            <c:if test="${book.user.id != user_id}">
                                <p>${book.user.userName} read ${book.title} by ${book.author}</p>
                            </c:if>
                        </div>
                        <div class="container">
                            <p class="border border-dark">${book.thoughts}</p>
                        </div>
                        <c:if test="${book.user.id == user_id}">
                            <div class="d-flex justify-content-between">
                                <div><a href="/book/${book.id}/edit" class="btn btn-outline-dark">Edit</a></div>
                            </div>
                            </c:if>
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