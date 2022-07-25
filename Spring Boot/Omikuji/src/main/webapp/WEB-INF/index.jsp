<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!doctype html>
        <html lang="en">

        <head>
            <title>Hello</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS v5.2.0-beta1 -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
                integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
                crossorigin="anonymous">

        </head>

        <body>
            <div class="container">
                <h1 class="my-3">Send an Omikuji!</h1>
                <form class="container border border-2 border-dark" method="POST" action="/omikuji/show">
                    <div class="container w-75 m-5">
                        <label class="form-label">Pick any number from 5 to 25</label>
                        <input type="number" class="form-control" name="number" min="3" max="25">
                    </div>
                    <div class="container w-75 m-5">
                        <label class="form-label">Enter the name of any city:</label>
                        <input type="text" class="form-control" name="city">
                    </div>
                    <div class="container w-75 m-5">
                        <label class="form-label">Enter the name of any real person:</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="container w-75 m-5">
                        <label class="form-label">Enter professional endeavor or hobby:</label>
                        <input type="text" class="form-control" name="hobby">
                    </div>
                    <div class="container w-75 m-5">
                        <label class="form-label">Enter any type of living thing:</label>
                        <input type="text" class="form-control" name="living">
                    </div>
                    <div class="container w-75 m-5">
                        <label class="form-label">Say something nice to someone:</label>
                        <textarea class="form-control" name="message" cols="30" rows="10"></textarea>
                    </div>
        
                    <p>Send and show a friend</p>
                    <button class="btn btn-primary" type="submit">Send</button>
                </form>
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