<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<p>Name:<c:out value ="${expense.name }"></c:out></p>
	<p>Vendor: <c:out value ="${expense.vendor }"></c:out></p>
	<p>Amount: <c:out value ="${expense.amount }"></c:out></p>

</body>
</html>