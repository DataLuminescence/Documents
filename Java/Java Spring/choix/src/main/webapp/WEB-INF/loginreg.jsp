<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Sign Up for Free!</h1>
	<h2>Register</h2>
	<form:form action="/register" method="post" modelAttribute="newUser">
		
		<div>
			<form:label path="userName">User Name:</form:label>
			<form:input path="userName" />
			<form:errors path="userName" />
		</div>
		<div>
			<form:label path="email">Email:</form:label>
			<form:input path="email" />
			<form:errors path="email" />	
		</div>
		<div>
			<form:label path="zipcode">Zipcode</form:label>
			<form:input path="zipcode" />
			<form:errors path="zipcode" />
		</div>
		<div>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<form:label path="confirm">Confirm PW:</form:label>
			<form:password path="confirm" />
			<form:errors path="confirm" />			
		</div>
		<div>
			<form:label path="terms">Agree to Terms of Service:</form:label>
			<form:checkbox path="terms"/>
			<form:errors path="terms" />	
		</div>
		
		<input type="submit" value="Register" />
	</form:form>
	
	<h2>Log in</h2>
	<form:form action="/login" method="post" modelAttribute="newLogin">
		
		<div>
			<form:label path="email">Email:</form:label>
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<form:label path="password">Password:</form:label>
			<form:password path="password" />
			<form:errors path="password" />
		</div>
				
		<input type="submit" value="Login" />
	</form:form>
	
</body>
</html>