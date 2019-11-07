<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<h1>Registration</h1>
	<a href="${pageContext.request.contextPath}/HomeServlet">Cancel</a>
	
	<% if (request.getAttribute("errorMessage") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	<% } %>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/registerMember" method="post">
		<table style="width:50%;">
		<tr>
			<td><label>First Name: </label></td>
			<td><input name="firstName" /></td>
		</tr>
		<tr>
			<td><label>Last Name: </label></td>
			<td><input name="lastName" /></td>
		</tr>
		<tr>
			<td><label>DOB: </label></td>
			<td><input name="userDOB" type="date" /></td>
		</tr>
		<tr>
			<td><label>Email: </label></td>
			<td><input name="userEmail" /></td>
		</tr>
		<tr>
			<td><label>Password: </label></td>
			<td><input name="userPassword" type="password" /></td>
		</tr>
		<tr>
			<td><label>Confirm Password: </label></td>
			<td><input name="password" type="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit Registration" /></td>
		</tr>
	</form>
</body>
</html>