<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cookies</title>
	<% 
		Cookie[] cookies = request.getCookies(); 
		Cookie favCookie = cookies[1];
		System.out.println(favCookie.toString());
		
	
	%>
	
</head>
<body>
<!-- Use expression language (EL) in the JSP to display the value of the cookie in the "CookiesPage.jsp" page - note that the cookie won't display the first time the application is run until the page is refreshed -->
	<h1>My Cookie Info</h1>
	<p>${favCookie.getName()}</p>
	<p>${favCookie.getValue()}</p>
	
	
</body>
</html>