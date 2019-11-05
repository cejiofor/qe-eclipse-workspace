<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	
	<% if (request.getAttribute("errorMessage") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	<% } %>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/loginMember" method="post">
		<div>
			<label>Name: </label>
			<input name="name" />
		</div>
		<div>
			<label>Password: </label>
			<input name="password" type="password" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
</body>
</html>