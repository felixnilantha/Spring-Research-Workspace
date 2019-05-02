<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id=wrapper>
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="listCustomers" items="${customers}">

					<c:url var="updateLink" value="/customers/showFormForUpdate">
						<c:param name="customerId" value="${listCustomers.id}" />
					</c:url>

					<c:url var="deleteLink" value="/customers/delete">
						<c:param name="customerId" value="${listCustomers.id}" />
					</c:url>

					<tr>
						<td>${listCustomers.firstName}</td>
						<td>${listCustomers.lastName}</td>
						<td>${listCustomers.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>
	</div>


</body>
</html>