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
	
	<% if (request.getAttribute("errorMessage") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
	<% } %>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/registerMember" method="post">
		<div>
			<label>Member Name: </label>
			<input name="name" />
		</div>
		<div>
			<label>Member Email: </label>
			<input name="email" />
		</div>
		<div>
			<label>Member Password: </label>
			<input name="password" type="password" />
		</div>
		<div>
			<label>Favorite Language: </label>
			<input name="favoriteLanguage" />
		</div>
		<div>
			<input type="submit" value="Submit Registration" />
		</div>
	</form>
</body>
</html>