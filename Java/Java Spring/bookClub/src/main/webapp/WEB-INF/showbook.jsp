<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Share</title>
</head>
<body>

	<h1>${book.title}"</h1>
	<a href="/books">Back to Shelves</a>

		
		<p>
			${book.user.userName} read ${book.title} by ${book.author}
		</p>
		
		<p>
			Here are ${book.user.userName}'s thoughts: ${book.thoughts}
		</p>
		<c:if test="${userId == book.user.id}">
			<button onclick="window.location.href='/books/${book.id}/edit'">Edit</button>
			<form action="/books/${book.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete"></form>
		</c:if>
		
</body>
</html>