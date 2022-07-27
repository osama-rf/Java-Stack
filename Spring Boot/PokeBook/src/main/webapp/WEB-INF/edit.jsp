<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <mvc:annotation-driven />
                <!doctype html>
                <html lang="en">

                <head>
                    <title>Edit expense</title>
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

                        <h1>Edit Item</h1>                
                    <form:form action="/expense${expense.id}" method="post" modelAttribute="expens">
                        <input type="hidden" name="_method" value="put">
                        <p>
                            <form:label path="expenseName">Expense Name: </form:label>
                            <form:errors path="expenseName" />
                            <form:input path="expenseName" />
                        </p>
                        <p>
                            <form:label path="vendor">Vendor:</form:label>
                            <form:errors path="vendor" />
                            <form:input path="vendor" />
                        </p>
                        <p>
                            <form:label path="amount">Amount: </form:label>
                            <form:errors path="amount" />
                            <form:input type="number" path="amount" />
                        </p>
                        <p>
                            <form:label path="description">Description: </form:label>
                            <form:errors path="description" />
                            <form:textarea path="description" />
                        </p>
                        <input type="submit" value="Submit" />
                        <a href="/expense">Go back</a>
                    </form:form>
                    <!-- Bootstrap JavaScript Libraries -->
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
                        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
                        crossorigin="anonymous"></script>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
                        integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
                        crossorigin="anonymous"></script>
                </body>
                </html>