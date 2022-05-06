<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info</title>
</head>
<body>

	<h1>Please fill out the following questions to complete your profile</h1>
	
	<form:form action="/saveUserInfo" enctype="multiselect/form-data" method="post" modelAttribute="infoUser">
   <form:input type="hidden" path="user" value="${loggedInUser.id}"/>
		<h2>Please select a your level of animal product consumption.</h2>
		<div>
			<form:label path="animal">Omnivore</form:label>
			<form:radiobutton path="animal" value="Omnivore"/>
			<form:label path="animal">Flexitarian</form:label>
			<form:radiobutton path="animal" value="Flexitarian"/>
			<form:label path="animal">Pescaterian</form:label>
			<form:radiobutton path="animal" value="Pescaterian"/>
			<form:label path="animal">Vegetarian</form:label>
			<form:radiobutton path="animal" value="Vegetarian"/>
			<form:label path="animal">Vegan</form:label>
			<form:radiobutton path="animal" value="Vegan"/>
		</div>		
		
		<h2>Please select any food allergies.</h2>
		<div>
			<form:checkboxes id="selectallergies" items = "${allergiesList}" path="allergies"/>
		</div>
		
		<h2>Please select any restrictions due to religious beliefs.</h2>
		<div>
			<form:label path="religious">Kosher</form:label>
			<form:radiobutton path="religious" value="Kosher"/>
			<form:label path="religious">Halal</form:label>
			<form:radiobutton path="religious" value="Halal"/>
			<form:label path="religious">Jain</form:label>
			<form:radiobutton path="religious" value="Jain"/>
			<form:label path="religious">N/A</form:label>
			<form:radiobutton path="religious" value="Other"/>
		</div>	
		
<%-- 		<h2>Please select any diets you are currently following.</h2>
		<div>
			<form:label path="lifestyle">Low-Carb</form:label>
			<form:checkbox path="lifestyle" value="Low-Carb"/>

			<form:label path="lifestyle">Keto</form:label>
			<form:checkbox path="lifestyle" value="Keto"/>

			<form:label path="lifestyle">Paleo</form:label>
			<form:checkbox path="lifestyle" value="Lactose"/>

			<form:label path="lifestyle">Other</form:label>
			<form:checkbox path="lifestyle" value="Gluten"/>
		</div> --%>
		
<%-- 		<h2>Please select the kind of restaurants you visit often. </h2>
		<div>
			<form:label path="cuisine">Japanese</form:label>
			<form:checkbox path="cuisine" value="Japanese"/>

			<form:label path="cuisine">Italian</form:label>
			<form:checkbox path="cuisine" value="Italian"/>

			<form:label path="cuisine">Seafood</form:label>
			<form:checkbox path="cuisine" value="Seafood"/>

			<form:label path="cuisine">Breakfast</form:label>
			<form:checkbox path="cuisine" value="Gluten"/>
			
			<form:label path="cuisine">Thai</form:label>
			<form:checkbox path="cuisine" value="Thai"/>
		</div>
		<div>
			<form:label path="cuisine">Chinese</form:label>
			<form:checkbox path="cuisine" value="Chinese"/>
			
			<form:label path="cuisine">Indian</form:label>
			<form:checkbox path="cuisine" value="Indian"/>

			<form:label path="cuisine">Mexican</form:label>
			<form:checkbox path="cuisine" value="Mexican"/>
			
			<form:label path="cuisine">Mediterranean</form:label>
			<form:checkbox path="cuisine" value="Thai"/>
			
			<form:label path="cuisine">American</form:label>
			<form:checkbox path="cuisine" value="American"/>
		</div> --%>
		
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>