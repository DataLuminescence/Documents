<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${language.name}</title>
</head>
<body>
	<a href="/language">Dashboard</a>
	<p>Language Name: <c:out value="${language.name}"></c:out></p>
	<p>Vendor: <c:out value="${language.creator}"></c:out></p>
	<p>Amount Spent: <c:out value="${language.version}"></c:out></p>
	
	
	
	<a href="/language/${language.id}/edit">Edit</a>
	
	
	
	<form action="/language/${language.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form> 
</body>
</html>