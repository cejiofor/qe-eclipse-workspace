<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet Exercise 1</h1>
	
	
	<form action="${pageContext.request.contextPath}/HomeServlet" method="post">
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<label>Password:&nbsp;<input type="password" name="password" /></label>
		<br>
		<input type="submit" name="sumbit" value="sumbit" />
	</form>
	
</body>
</html>