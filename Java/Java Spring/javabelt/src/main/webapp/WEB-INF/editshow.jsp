<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Task</title>
</head>
<body>
	<h1>${show.title}</h1>
	<form:form action="/shows/${show.id}/update" method="post" modelAttribute="show">
    <input type="hidden" name="_method" value="put">
		<div>
			<form:label path="title">Title:</form:label>
			<form:input path="title" value="${show.title}"></form:input>
			<form:errors path="title" />
		</div>
		<div>
			<form:label path="network">Network</form:label>
			<form:input path="network" value="${show.network}"></form:input>
			<form:errors path="network" />
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:textarea path="description" value="${show.description}" rows="4" cols="50"></form:textarea>
			<form:errors path="description" />
		</div>				
		<div>
			<input type="button" onclick="location.href='/shows';" value="Cancel" />
			<form:input type="hidden" path="user" value="${show.user.id}"/>
			<input type="submit" value="Submit" />
		</div>
	</form:form>
	
	<c:if test="${userId == show.user.id}">
		<form action="/shows/${show.id}/delete" method="post">
			<div>
				<input type="hidden" name="_method" value="delete">
				<input type="submit" value="Delete Show">
			</div>
		</form>		
	</c:if>
	
</body>
</html>