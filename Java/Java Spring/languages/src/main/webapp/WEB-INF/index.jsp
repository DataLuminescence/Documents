<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page isErrorPage = "true" %>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${allLanguages}">
				<tr>
					<td><a href="/language/${language.id}/show"><c:out value="${language.name}"></c:out></a></td>
					<td><c:out value="${language.creator}"></c:out></td>
					<td><c:out value="${language.version}"></c:out></td>
					<td>
						<form action="/language/${language.id}/delete" method="post">
					    	<input type="hidden" name="_method" value="delete">
					    	<input type="submit" value="Delete">
						</form> 
					</td>
					<td><a href="/language/${language.id}/edit">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div>
		<%@ taglib prefix="form"
			uri="http://www.springframework.org/tags/form"%>
		<form:form action="/language/add" method="post" modelAttribute="language">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator" />
				<form:input path="creator" />
			</p>
			<p>
				<form:label path="version">Version</form:label>
				<form:errors path="version" />
				<form:input path="version" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>