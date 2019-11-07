<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
	<h1>Profile Page</h1>
	<h2>ID: ${currentUser.userId}</h2>
	<h2>User Name: ${currentUser.userName}</h2>
	<h2>Password: ${currentUser.password}</h2>
	<a href="${pageContext.request.contextPath}/MainServlet/showUpdate">Edit Profile</a> 
</body>
</html>