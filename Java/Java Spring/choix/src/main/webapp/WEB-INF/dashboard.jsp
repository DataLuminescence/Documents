<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<button onclick="window.location.href='/restaurants'">Restaurants</button>
	<button onclick="window.location.href='/reviews'">Reviews</button>
	<button onclick="window.location.href='/foodies'">Foodies</button>
	<button onclick="window.location.href='/photos'">Photos</button>
</body>
</html>