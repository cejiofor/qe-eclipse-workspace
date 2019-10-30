<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
	<!-- The Java code on this page will run any time the page is loaded. However, 
	the outer if statement below will not run unless the "Login" button has been clicked. 
	-->
	<% 	String error = null;
		Cookie[] cookies = request.getCookies();
		String usrName = null;
		String usrPassword = null;
		
		for(Cookie c : cookies){
			if(c.getName().equals("username")){
				usrName = c.getValue();
			}
			if(c.getName().equals("password")){
				usrPassword = c.getValue();
			}
		}
		
		if (request.getParameter("login") != null) {
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			if (userName.equals(usrName) && userPassword.equals(usrPassword)) {
				response.sendRedirect("Birthday.jsp");
			} else {
				error = "Login unsuccessful.";
			}
		}
		if (request.getParameter("login") != null) {
			response.sendRedirect("Register.jsp");
		}
		
		
		%>	
	</head>
<body>
	
		
	<h1>Login Form</h1>
	
	<% if (error != null) {%>
		<p style="color: red;"><%= error %></p>
	<% } %>
	
	<form action="Birthday.jsp" method="post">
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<label>Password:&nbsp;<input type="password" name="userPassword" /></label>
		<br>
		<input type="submit" name="login" value="Login" />
	</form>
	<form action="Register.jsp" method="post">
		<input type="submit" name="Register" value="Register" />
	</form>
</body>
</html>