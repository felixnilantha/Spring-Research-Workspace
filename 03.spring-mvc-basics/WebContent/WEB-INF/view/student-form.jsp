<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">

		First name :<form:input path="firstName" />

		<br>
		<br>
		Last name :<form:input path="lastName" />


		<br>
		<br>
		
		Country :
		
		<form:select path="country">
			<form:options items="${student.countryOptions}"></form:options>

		</form:select>

		<br>
		<br>


		
		Favorite Language :
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		Scala <form:radiobutton path="favoriteLanguage" value="Scala" />

		<br>
		<br>

		Operating Systems :

		Linux <form:checkbox path="operatingSystems" value="Java" />
		MAC <form:checkbox path="operatingSystems" value="MAC OS" />
		MS Windows# <form:checkbox path="operatingSystems" value="Microsoft Windows" />


		<br>
		<br>


		<input type="submit" value="Submit">
	</form:form>

</body>
</html>