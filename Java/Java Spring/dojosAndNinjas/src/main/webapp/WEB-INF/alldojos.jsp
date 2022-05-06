<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Dojo Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${allDojos}">
				<tr>
					<td><a href="/dojos/show/${dojo.id}"><c:out value="${dojo.name}"></c:out></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>