<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Manager Dashboard</title>
</head>
<body>
	<a href="/logout">Logout</a>
	<h1>Welcome, ${loggedInUser.userName}!</h1>
	<h2>TV Shows</h2>
	
	<table>
		<thead>
			<tr>
				<th>Show</th>
				<th>Network</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="show" items="${allShows}">
				<tr>
					<td><a href="/shows/${show.id}"><c:out value="${show.title}"></c:out></a></td>
					<td><c:out value="${show.network}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="window.location.href='/new'">Add a Show</button>
</body>
</html>