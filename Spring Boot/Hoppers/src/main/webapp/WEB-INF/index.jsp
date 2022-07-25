<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8" />
            <title>Hopper's Receipt</title>
            <title>hello world</title>
            <link rel="stylesheet" type="text/css" href="/css/style.css">
            <script type="text/javascript" src="/js/script.js"></script>

            <!-- for Bootstrap CSS -->
            <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
            <!-- YOUR own local CSS -->
            <link rel="stylesheet" href="/css/main.css"/>
            <!-- For any Bootstrap that uses JS or jQuery-->
            <script src="/webjars/jquery/jquery.min.js"></script>
            <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
        </head>

        <body>
            <h1>Costumer Name:
                <c:out value="${name}" />
            </h1>
            <p>Item:
                <c:out value="${itemName}" />
            </p>
            <p>Price:
                <c:out value="${price}" />
            </p>
            <p>Description:
                <c:out value="${description}" />
            </p>
            <p>Vendor:
                <c:out value="${vendor}" />
            </p>

        </body>

        </html>