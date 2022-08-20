<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Club - Add Book</title>

	<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- <script type="text/javascript" src="/js/script.js"></script> -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<h1 class="display-4">Add a Book to Your Shelf!</h1>
			<form:form action="/books/new" modelAttribute="book" method="POST" class="col-5 mt-4 p-3">
				<div class="mb-3">
					<form:label path="title" class="form-label">Title:</form:label>
					<form:input type="text" path="title" class="form-control" />
				</div>
				<div><form:errors path="title" /></div>
				<div class="mb-3">
					<form:label path="author" class="form-label">Author:</form:label>
					<form:input type="text" path="author" class="form-control" />
				</div>
				<div><form:errors path="author" /></div>
				<div class="mb-3">
					<form:label path="thoughts" class="form-label">My Thoughts:</form:label>
					<form:textarea path="thoughts" class="form-control"></form:textarea>
				</div>
				<div><form:errors path="thoughts" /></div>
				<input type="submit" value="Add Book" class="btn btn-sm btn-primary" />
			</form:form>
		</div>
	</div>

</body>
</html>