<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Books</title>
</head>
<body>

	<p><c:out value ="${book.title }"></c:out></p>
	<p>Description: <c:out value ="${book.description }"></c:out></p>
	<p>Language: <c:out value ="${book.language }"></c:out></p>
	<p>Number of Pages: <c:out value ="${book.numberOfPages }"></c:out></p>

</body>
</html>