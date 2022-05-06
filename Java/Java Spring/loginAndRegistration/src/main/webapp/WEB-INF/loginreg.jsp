<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
	<h1>Welcome</h1>
	<h2>Join our growing community</h2>
	<h2>Register</h2>
	<form:form action="/register" method="post" modelAttribute="newUser">
		
		<p>
			<form:label path="userName">User Name:</form:label>
			<form:input path="userName" />
			<form:errors path="userName" />
		</p>
		
		<p>
			<form:label path="email">Email:</form:label>
			<form:input path="email" />
			<form:errors path="email" />			
		</p>

		<p>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		
		<p>
			<form:label path="confirm">Confirm PW:</form:label>
			<form:password path="confirm" />
			<form:errors path="confirm" />			
		</p>
		
		<input type="submit" value="Submit" />
	</form:form>
	
	<h2>Login</h2>
	<form:form action="/login" method="post" modelAttribute="newLogin">
		
		<p>
			<form:label path="email">Email:</form:label>
			<form:input path="email" />
			<form:errors path="email" />
		</p>

		<p>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<form:errors path="password" />
		</p>
		
		<input type="submit" value="Submit" />
	</form:form>
	
</body>
</html>