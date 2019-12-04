<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="${pageContext.request.contextPath}/registerUser" method="get">
		<table>
			<tr>
				<td><label for="username">Username: </label></td>
				<td><form:input type="text" path="name" name="name"/></td>
			</tr>
			<tr>
				<td><label for="password">Password: </label></td>
				<td><form:input type="password" path="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="register" value="Register"></td>
				<td><input type="reset"></td>
			</tr>
		</table>
	</form>
	
	<a href="${pageContext.request.contextPath}/">Login Page</a>
</body>
</html>