<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji</h1>
	
	<form action="/omikuji/processForm" method="post">
		<p>
			<label> Enter a number from 5-25 </label>
			<input type="number" min=5 max=25 name="number"/>
		</p>
		<p>
			<label> Enter the name of any city</label>
			<input type="text" name="city"/>
		</p>
		<p>
			<label> Enter the name of a real person</label>
			<input type="text" name="name"/>
		</p>
		<p>
			<label> Enter professional endeavor or hobby</label>
			<input type="text" name="activity"/>
		</p>			
		<p>
			<label> Enter any type of living thing</label>
			<input type="text" name="being"/>
		</p>
		<p>
			<label> Say something nice to someone</label>
			<textarea name="comment"></textarea>
		</p>
		<p>
			<label> Send and show a friend</label>
			<button> Send</button>
		</p>
	
	</form>
</body>
</html>