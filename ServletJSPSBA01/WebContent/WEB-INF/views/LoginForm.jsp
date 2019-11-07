<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	
	<p style="color:red;">${errorMessage}</p>
	
	<form action="${pageContext.request.contextPath}/MainServlet/loginForm" method="post">
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