<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classified Adds</title>
</head>
<body>
	<h1>Login Page</h1>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td><label for="name">Username: </label></td>
				<td><form:input type="text" path="username" required="required"/></td>
			</tr>
			
			<tr>
				<td><label for="password">Password: </label></td>
				<td><form:input type="password" path="password" required="required"/></td>
			</tr>
			<tr> 
				<td><input type="submit"></td>
				<td><input type="reset"></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/register">Register</a></td>
			</tr>
		</table>
	</form>
</body>
</html>