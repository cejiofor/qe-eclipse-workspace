<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.time.LocalDateTime, java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servlets/JSP Project 1</title>
</head>
<body>
	<h1>Hello!</h1>
	<p>Good Morning! Today is:</p>
	<% LocalDateTime current = LocalDateTime.now(); %>
	<% out.print(current.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a"))); %>
</body>
</html>