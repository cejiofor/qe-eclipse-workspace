<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Link Tag URL Rewriting</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/LinkTagServlet?param=Good Morning">Good Morning</a>
	<a href="${pageContext.request.contextPath}/LinkTagServlet?param=Good Evening">Good Evening</a>
</body>
</html>