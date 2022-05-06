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

	<h1>Change Your Entry</h1>
	<a href="/books">Back to Shelves</a>
	
	<form:form action="/books/${book.id}/update" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
		
		<p>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${book.title}"></form:input>
			
			<form:errors path="title" />
		</p>
		
		<p>
			<form:label path="author">Author:</form:label>
			<form:input path="author" value="${book.author}"></form:input>
			<form:errors path="author" />
		</p>
		
		<p>
		<!-- text area needs editing -->
			<form:label path="thoughts">My Thoughts:</form:label>
			<form:textarea path="thoughts" value="${book.thoughts}" rows="4" cols="50"></form:textarea>
			<form:errors path="thoughts" />
		</p>
		
		<p>
		<!-- How do we properly pass in the loggedInUser to get the poster data -->
			<form:input type="hidden" path="user" value="${book.user.id}"/>
		</p>
		 
		<input type="submit" value="Submit" />
	</form:form>	
</body>
</html>