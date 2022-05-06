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

	<h1>Add a Book to Your Shelf!</h1>
	<a href="/books">Back to Shelves</a>
	
	<form:form action="/add" method="post" modelAttribute="newBook">
		
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</p>
		
		<p>
			<form:label path="author">Author:</form:label>
			<form:input path="author" />
			<form:errors path="author" />
		</p>
		
		<p>
		<!-- text area needs editing -->
			<form:label path="thoughts">My Thoughts:</form:label>
			<form:textarea path="thoughts" rows="4" cols="50" />
			<form:errors path="thoughts" />
		</p>
		
		<p>
		<!-- How do we properly pass in the loggedInUser to get the poster data -->
			<form:input type="hidden" path="user" value="${userId}"/>
		</p>
		 
		<input type="submit" value="Submit" />
	</form:form>	
</body>
</html>