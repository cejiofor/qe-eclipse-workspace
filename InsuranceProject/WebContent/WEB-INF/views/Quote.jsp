<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.perscholas.models.Home"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check OUt Quote</title>
</head>
<body>
	<h1>Insurance Premium</h1>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/addQuote" method=post>
		<% 
			Home currentHome = (Home) session.getAttribute("currentHome");
			double premium = currentHome.getHomeValue()*0.05;
			session.setAttribute("premium", premium);
		%>
		<h2>${premium}</h2>
		<button type="submit" value="CheckOut">CheckOut</button>
	
	</form>
		
</body>
</html>