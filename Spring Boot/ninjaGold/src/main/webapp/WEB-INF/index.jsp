<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!doctype html>
        <html lang="en">

        <head>
            <title>Ninja Gold</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS v5.2.0-beta1 -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
                integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
                crossorigin="anonymous">

            <style>
                #btm {
                    height: 200px;
                }
            </style>
        </head>

        <body>
            <div class="container d-flex flex-column justify-content-around">

                <h1 class="mx-auto">Ninja Gold</h1>

                <div class="row mt-4">
                    <div class="form-group">
                        <label>Your Gold: </label>
                        <input type="text" class="form-control w-25" name="gold" disabled
                            value="<c:out value='${gold}'/>">
                    </div>
                </div>

                <div class="row mt-4">
                    <div class="col border border-dark border-2 d-flex flex-column align-items-center m-2">
                        <h1>Farm</h1>
                        <p>(earns 10-20 gold)</p>
                        <form action="/gold" method="post">
                            <input type="hidden" value="farm" name="location">
                            <button>Find Gold</button>
                        </form>
                    </div>
                    <div class="col border border-dark border-2 d-flex flex-column align-items-center m-2">
                        <h1>Cave</h1>
                        <p>(earns 10-20 gold)</p>
                        <form action="/gold" method="post">
                            <input type="hidden" value="cave" name="location">
                            <button>Find Gold</button>
                        </form>
                    </div>
                    <div class="col border border-dark border-2 d-flex flex-column align-items-center m-2">
                        <h1>House</h1>
                        <p>(earns 10-20 gold)</p>
                        <form action="/gold" method="post">
                            <input type="hidden" value="house" name="location">
                            <button class="mb-4">Find Gold</button>
                        </form>
                    </div>
                    <div class="col border border-dark border-2 d-flex flex-column align-items-center m-2">
                        <h1>Quest</h1>
                        <p>(earns/takes 0-50 gold)</p>
                        <form action="/gold" method="post">
                            <input type="hidden" value="quest" name="location">
                            <button type="submit">Find Gold</button>
                        </form>
                    </div>
                </div>

                <div id="btm" class="row mt-4">
                    <div class="form-group">
                        <label>Activities</label>
                        <div id="log" class="form-control border border-2 border-dark">
                                <c:forEach var="info" items="${log}">
                                     <p class="
                                     <c:choose>
                                     <c:when test="${!info.contains('lose')}">
                                     text-success
                                     </c:when>

                                     <c:otherwise>
                                     text-danger
</c:otherwise>
</c:choose>

                                                ">
                                         <c:out value="${info}"/>
                                     </p>
                                </c:forEach>
                        </div>
                    </div>
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