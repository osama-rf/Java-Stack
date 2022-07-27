<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!doctype html>
            <html lang="en">

            <head>
                <title>Song Details</title>
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
                <div class="container w-75 mx-4">
                    <div class="container mt-2 d-flex justify-content-end align-items-center">
                        <a href="/dashboard">Dashboard</a>
                    </div>

                    <div class="container mt-5">
                        <p>
                            Title:
                            <c:out value="${song.title}" />
                        </p>
                        <p>
                            Artist:
                            <c:out value="${song.artist}" />
                        </p>
                        <p>
                            Rating (1-10):
                            <c:out value="${song.rate}" />
                        </p>
                        <p>
                            <form:form method="post" action="/songs/${song.id}/delete">
                                <input type="hidden" name="_method" value="DELETE">
                                <button class="btn btn-link">Delete</button>
                            </form:form>
                        </p>
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