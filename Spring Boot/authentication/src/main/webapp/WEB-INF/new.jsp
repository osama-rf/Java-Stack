<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <!doctype html>
                <html lang="en">

                <head>
                    <title>Add new Book</title>
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
                            <h2>Add a Book to Your Shelf!</h2>
                            <a href="/book">back to the shelves</a>
                        </div>
                        <div class="container">
                            <form:form action="/book/add" method="post" modelAttribute="book" class="form">
                                <form:label path="title" class="form-label">Title</form:label>
                                <form:errors path="title" class="text-danger"></form:errors>
                                <form:input path="title" type="text" class="form-control"/>
                                
                                <form:label path="author" class="form-label">Author</form:label>
                                <form:errors path="author" class="text-danger"></form:errors>
                                <form:input path="author" type="text" class="form-control"/>
                                
                                <form:label path="thoughts" class="form-label">Thoughts</form:label>
                                <form:errors path="thoughts" class="text-danger"></form:errors>
                                <form:textarea path="thoughts" type="text" class="form-control"></form:textarea>
                                
                                <form:hidden path="creator" value="${userId}"/>
                                
                                <button class="btn btn-primary mt-3">Submit</button>
                            </form:form>
                        </div>
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