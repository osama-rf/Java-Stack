<!-- Here we have to import the Date class. -->
<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hopper's Receipt</title>
</head>
<body>

<h1>Customer Name: <c:out value="${name}"></c:out></h1>
<p>Item Name: <c:out value="${itemName}"></c:out> </p>
<p>Price: <c:out value="${price}"></c:out> </p>
<p>Description: <c:out value="${description}"></c:out> </p>
<p>Vendor: <c:out value="${vendor}"></c:out> </p>

</body>
</html>


<%--model.addAttribute("name", name);--%>
<%--model.addAttribute("itemName", itemName);--%>
<%--model.addAttribute("price", price);--%>
<%--model.addAttribute("description", description);--%>
<%--model.addAttribute("vendor", vendor);--%>