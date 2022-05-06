<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
</head>
<body>
<h1>All Books</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Languages</th>
				<th># Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books }">
				<tr>
					<td>${book.id }</td>
					<td>
						<a href="/book/${book.id }">
							<c:out value="${book.title }"></c:out>
						</a>
					</td>
					<td>${book.language}</td>
					<td>${book.numberOfPages }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>