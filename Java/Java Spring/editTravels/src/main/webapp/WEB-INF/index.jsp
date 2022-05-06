<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page isErrorPage = "true" %>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${allExpenses}">
				<tr>
					<td><c:out value="${expense.name}"></c:out></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td><c:out value="${expense.amount}"></c:out></td>
					<td><a href="/expense/${expense.id}/edit">Edit</a></td>
			</c:forEach>
		</tbody>
	</table>


	<div>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
		<h1>Add an Expense</h1>
		<h2>Description must not be blank</h2>
		<form:form action="/expense/add" method="post" modelAttribute="expense">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" />
			</p>
			<p>
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" />
				<form:input path="amount" />
			</p>
			<p>
			  	<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:textarea path="description"></form:textarea>
			</p>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>