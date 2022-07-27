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
                <div class="container w-75 text-center ">
                    <div class="container mt-2 d-flex justify-content-around align-items-center">
                        <a href="/songs/new">Add New</a>
                        <a href="/search/topTen">Top Songs</a>
                
                        <form class="d-flex align-items-center" method="POST" action="/search">
                            <input name="artist" type="text" class="form-control" />
                            <button type="submit" class="btn btn-dark mx-2 form-control">Search Artists</button>
                        </form>
                
                    </div>
                
                    <div class="container mt-5">
                        <table class="table table-hover">
                            <thead class="table-dark text-white">
                                <tr>
                                    <th>Name</th>
                                    <th>Rating</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                
                            <tbody>
                                <c:forEach var="song" items="${songs}">
                                    <tr>
                                        <td>
                                            <a href="/songs/<c:out value='${song.id}'/>">
                                                    <c:out value="${song.title}"/>
                                            </a>
                                        </td>
                                        <td>
                                            <c:out value="${song.rate}"/>
                                        </td>
                                        <td>
                                            <form:form action="/songs/${song.id}/delete" method="POST">
                                                <input type="hidden" name="_method" value="DELETE">
                                                <button class="btn btn-link">delete</button>
                                            </form:form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
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