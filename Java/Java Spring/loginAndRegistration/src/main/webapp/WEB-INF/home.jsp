<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>

	<h1>Welcome, ${loggedInUser.userName}!</h1>

	<p>This is your dashboard. Nothing to see here yet.</p>
	
	<a href="/">Logout</a>
	
</body>
</html>