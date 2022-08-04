<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<a href="/home" class="nav-link mb-3">Back to the Bookshelf!</a>
			<main class="col-8 px-4 py-3 border border-1 border-pirmary rounded bg-light">
				<div>
					<h1 class="display-5 mb-4"><c:out value="${book.title}" /></h1>
					<h4 class="mb-3"><span class="text-danger"><c:out value="${book.user.getName()}" /></span> read <span class="text-primary"><c:out value="${book.title}" /></span> by <span class="text-success"><c:out value="${book.author}" /></span>.</h4>
					<h5 class="mb-2">Here are <c:out value="${book.user.getName()}" />'s thoughts:</h5>
					<hr />
					<p><c:out value="${book.thoughts}" /></p>
					<hr />
				</div>
				<div class="text-end">
					<c:if test="${book.user == user}"><a href="/books/${book.id}/edit" class="nav-link">Edit</a></c:if>
				</div>
			</main>
		</div>
	</div>

</body>
</html>