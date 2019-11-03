<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cookie Jar Page</title>
	<% 
		Cookie[] cookies = request.getCookies();
		Cookie favCookie = null;
		for(Cookie c:cookies){
			if (c.getName().equals("myFavoriteCookie"));
				{
					favCookie = c;
				}
		}

		request.setAttribute("favCookie", favCookie);
		
	%>
	
</head>
<body>
<!-- Use expression language (EL) in the JSP to display the value of the cookie in the "CookiesPage.jsp" page - note that the cookie won't display the first time the application is run until the page is refreshed -->
	<h1>My Cookie Info</h1>
	<p><% out.print(favCookie.getName()); %></p>
	<p><% out.print(favCookie.getValue()); %></p>
	
	<a href="${pageContext.request.contextPath}/CookiesServlet">Cookies Page</a>
	
</body>
</html>