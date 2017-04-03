<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<title>Customer List</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>This is the CRM table</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<!-- Adding the Button to add the new customer type -->
			<input class="add-button" type="button" value="Add Customer"
				onClick="window.location.href = 'showFormForAdd';return false" />


			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- Loop over the customers -->
				<c:forEach items="${customers}" var="tempCustomers">
					<!-- Construct an update link for the customers -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomers.id}"></c:param>

					</c:url>

					<!-- Construct an delete link for the customers -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomers.id}"></c:param>

					</c:url>

					<tr>
						<td>${tempCustomers.firstName}</td>
						<td>${tempCustomers.lastName}</td>
						<td>${tempCustomers.email}</td>
						<td><a href="${updateLink}">Update</a>|<a
							href="${deleteLink}"
							onClick="if(!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a></td>

					</tr>
				</c:forEach>


			</table>



		</div>
	</div>


</body>
</html>