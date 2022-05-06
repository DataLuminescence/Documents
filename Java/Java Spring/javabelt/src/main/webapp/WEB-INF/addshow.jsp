<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a Task</title>
</head>
<body>
	<h1>Create a New TV Show</h1>
	<form:form action="/add" method="post" modelAttribute="newShow">
		<div>
			<form:label path="title">Title:</form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="network">Network</form:label>
			<form:input path="network" />
			<form:errors path="network" />
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:textarea path="description" rows="4" cols="50" />
			<form:errors path="description" />
		</div>
		<div>
			<input type="button" onclick="location.href='/shows';" value="Cancel" />
			<form:input type="hidden" path="user" value="${userId}"/>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
</body>
</html>