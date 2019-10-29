<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<form action="LoginServlet" method="post">
		<div>
			<label>User Name:</label>
			<input type="text" name="userName"/>
		</div>
		<div>
			<label>Password:</label>
			<input type="text" name="password"/>
		</div>
		<div>
			<input type="submit" value="Login"/>
		</div>
	</form>
</body>
</html>