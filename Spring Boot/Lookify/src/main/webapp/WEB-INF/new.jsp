<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <div class="container mx-4">
                    <div class="container mt-2 d-flex justify-content-end align-items-center">
                        <a href="/dashboard">Dashboard</a>
                    </div>

                    <div class="container w-50 mt-5">
                        <form:form method="POST" action="/songs/create" modelAttribute="song">
                            <form:label path="title">Title:</form:label>
                            <form:input class="form-control" path="title" />

                            <form:label class="mt-4" path="artist">Artist:</form:label>
                            <form:input class="form-control" path="artist" />

                            <form:label class="mt-4" path="rate">Rate:</form:label>
                            <form:input class="form-control" type="Number" path="rate" />

                            <button class="btn btn-dark mt-4">Add Song</button>
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