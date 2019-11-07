<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You Page </title>
</head>
<body>
	<h1> Thank You For Your Business</h1>
	
	<p> One of Our Customer Reps. will reach out to you soon to activate your home policy</p>
	
	<button onclick="window.location.href='${pageContext.request.contextPath}/HomeServlet/showWelcome'" value="Back to Home Page">Back to Home Page</button>
	
</body>
</html>