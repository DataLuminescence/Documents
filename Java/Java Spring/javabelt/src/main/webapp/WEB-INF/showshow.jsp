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
	<a href="/shows">Back to Dashboard</a>
	<h1>${show.title}</h1>
	<div>
		Posted by: ${show.user.userName}
	</div>
	<div>
		Network: ${show.network}
	</div>
	<div>
		Description: ${show.description}
	</div>
	<c:if test="${userId == show.user.id}">
		<div>
			<input type="button" onclick="location.href='/shows/${show.id}/edit';" value="Edit" />
		</div>	
	</c:if>
</body>
</html>