<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    
<html>
<head>
<meta charset="UTF-8">
<title>${language.name}</title>
</head>
<body>
	<form action="/language/${language.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
		<a href="/language">Dashboard</a>
	</form> 

	<form:form action="/language/${language.id}/edit" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<div>
				<p>
					<form:label path="name">Name</form:label>
					<form:input path="name" />
				</p>
					<form:errors path="name" style="color:red"/>
			</div>
			<div>
				<p>
					<form:label path="creator">Creator</form:label>
					<form:input path="creator" />
				</p>
					<form:errors path="creator" style="color:red"/>
			</div>
			<div>
				<p>
					<form:label path="version">Version</form:label>
					<form:input path="version" />
				</p>
					<form:errors path="version" style="color:red"/>		
			</div>
			<input type="submit" value="Submit" />
	</form:form>

</body>
</html>