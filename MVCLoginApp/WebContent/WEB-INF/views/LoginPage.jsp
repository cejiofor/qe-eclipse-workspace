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
	
<%-- 	<p style="color:red;">${errorMessage}</p> --%>
	
	<a href="#">Register Here</a>
	<form action="#" method="post">
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