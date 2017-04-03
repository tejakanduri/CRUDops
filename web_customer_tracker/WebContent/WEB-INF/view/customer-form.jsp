<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<title>Customer Insertion Form</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div>
		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			
			<!-- Need to associate this data with the customer Id -->
			<form:hidden path = "id" />
			<table>
				<tbody>
					<tr>

						<td><label>First Name : </label></td>
						<td><form:input path="firstName" /></td>

					</tr>

					<tr>

						<td><label>Last Name : </label></td>
						<td><form:input path="lastName" /></td>

					</tr>

					<tr>

						<td><label>Email : </label></td>
						<td><form:input path="email" /></td>

					</tr>

					<tr>

						<td><label></label></td>
						<td><input type="submit" value="save" class="save" /></td>

					</tr>
				</tbody>
			</table>
		</form:form>
	</div>

	<div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>

	</div>




</body>
</html>