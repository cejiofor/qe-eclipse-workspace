<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Exercise</title>
</head>
<body>
	<h1>Servlet Exercise 1</h1>
		
	<form  action="${pageContext.request.contextPath}/HomeServlet" method="POST">
	  Username: <input type="text" name="userName"><br>
	  Password: <input type="password" name="password"><br>
	  <input type="submit" value="Submit">
	</form>

</body>
</html>