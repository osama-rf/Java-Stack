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

	<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- <script type="text/javascript" src="/js/script.js"></script> -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-4">
			<header class="row justify-content-between align-items-center">
				<div class="col-5 text-start">
					<h4>Hello, ${user.name}. Welcome to...</h4>
					<h1 class="display-4">The Book Broker!</h1>
				</div>
				<div class="col-5 text-end">
					<a href="/logout" class="nav-link">Logout</a>
					<a href="/books/new" class="nav-link">Add to My Shelf</a>
				</div>
			</header>
			<main class="row mx-auto mt-3" style="width: 85%;">
				<table class="table table-striped table-bordered caption-top">
					<caption>Books Available to Borrow:</caption>
					<thead class="table-info">
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Author</th>
							<th>Owner</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<c:if test="${book.borrower == null}">
								<tr class="align-middle">
									<td><c:out value="${book.id}" /></td>
									<td><a href="/books/${book.id}" class="nav-link"><c:out value="${book.title}" /></a></td>
									<td><c:out value="${book.author}" /></td>
									<td><c:out value="${book.user.getName()}" /></td>
									<td>
										<c:if test="${book.user == user}"><a href="/books/${book.id}/edit" class="btn btn-sm btn-primary">Edit</a></c:if>
										<c:if test="${book.user == user}">
											<form:form action="/books/${book.id}/delete" method="POST" style="display: inline-block;">
	    											<input type="hidden" name="_method" value="DELETE">
	    											<input type="submit" value="Delete" class="btn btn-sm btn-danger ms-2">
											</form:form>
										</c:if>
										<c:if test="${book.user != user}">
											<form:form action="/borrow/${book.id}" method="POST" style="display: inline-block;">
	    											<input type="hidden" name="_method" value="PUT">
	    											<input type="submit" value="Borrow" class="btn btn-sm btn-light">
											</form:form>
										</c:if>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
				<table class="table table-striped table-bordered caption-top mt-3">
					<caption>Books I'm Borrowing:</caption>
					<thead class="table-warning">
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Author</th>
							<th>Owner</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<c:if test="${book.borrower == user}">
								<tr class="align-middle">
									<td><c:out value="${book.id}" /></td>
									<td><a href="/books/${book.id}" class="nav-link"><c:out value="${book.title}" /></a></td>
									<td><c:out value="${book.author}" /></td>
									<td><c:out value="${book.user.getName()}" /></td>
									<td>
										<form:form action="/return/${book.id}" method="POST" style="display: inline-block;">
    											<input type="hidden" name="_method" value="PUT">
    											<input type="submit" value="Return" class="btn btn-sm btn-secondary">
										</form:form>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</main>
		</div>
	</div>

</body>
</html>