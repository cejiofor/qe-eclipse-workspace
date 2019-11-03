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
	<% 	
	String error = null;	
	if (request.getParameter("login") != null) {
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
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		if (userName.equals(usrName) && userPassword.equals(usrPassword)) {
			// response.sendRedirect("Birthday.jsp");
			request.getRequestDispatcher("Birthday.jsp").forward(request, response);
		} 
		else {
			request.setAttribute("error","Invaild username or password");
			// error = "Invaild username or password";
			// response.sendRedirect("LoginForm.jsp");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		}
	} 
	else if(request.getParameter("register") != null) {
			request.getRequestDispatcher("Register.jsp").forward(request, response);
	}
		
		
		%>	
	</head>
<body>
	<h1>Login Form</h1>
	<% if (request.getAttribute("error") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
	
	<form action="LoginForm.jsp" method="post">
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<label>Password:&nbsp;<input type="password" name="userPassword" /></label>
		<br>
		<input type="submit" name="login" value="Login" />
	</form>
	<form action="Register.jsp" method="post">
		<input type="submit" name="register" value="Register" />
	</form>
</body>
</html>