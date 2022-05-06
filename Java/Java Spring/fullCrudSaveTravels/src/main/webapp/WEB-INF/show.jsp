<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/expense">Go Back</a>
	<p>Expense Name: <c:out value="${expense.name}"></c:out></p>
	<p>Expense Description: <c:out value="${expense.description}"></c:out></p>
	<p>Vendor: <c:out value="${expense.vendor}"></c:out></p>
	<p>Amount Spent: <c:out value="${expense.amount}"></c:out></p>
</body>
</html>