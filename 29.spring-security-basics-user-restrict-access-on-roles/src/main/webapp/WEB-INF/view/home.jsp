<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Basics</title>
</head>
<body>

	<h2>Spring Security Basics Home Page</h2>
	<hr>

	Welcome to spring security basics home page
	<hr>
	<!-- display username and role -->

	<p>
		User :
		<sec:authentication property="principal.username" />
		<br> <br> Role (s):
		<sec:authentication property="principal.authorities" />
	</p>



	<sec:authorize access="hasRole('MANAGER')">
		<hr>
		<!-- Adding a link to leader -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting </a> (Only for managers )
		</p>
	</sec:authorize>


	<sec:authorize access="hasRole('ADMIN')">
		<hr>
		<!-- Adding a link to systems -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">Systems
				Admin meeting </a> (Only for Admins )
		</p>

	</sec:authorize>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>

</body>
</html>