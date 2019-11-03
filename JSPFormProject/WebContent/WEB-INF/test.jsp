<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>

<% 	
		String username = "", password = "";

		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			if(c.getName().equals("username")){
				username = c.getValue();
// 				out.println(username);
			}
			if(c.getName().equals("password")){
				password = c.getValue();
// 				out.println(password);
			}
		}
	
		String error = null;
		if (request.getParameter("loginbtn") != null) {
			String userName = request.getParameter("usernameIn");
			String userPassword = request.getParameter("passwordIn");
// 			out.println("INPUT" + userName);
// 			out.println("INPUT" + userPassword);
			if (userName.equals(username) && userPassword.equals(password)) {
				response.sendRedirect("welcome.jsp");
			} else {
				error = "Login unsuccessful.";
			}
		} %>

<body>
	<h1>Login Form</h1>
	<% if (request.getAttribute("error") != null) {%>
	    <p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
	
	<form action="${pageContext.request.contextPath}/Login" method="post">
		<label>User Name:&nbsp;<input type="text" name="usernameIn" /></label>
		<label>Password:&nbsp;<input type="password" name="passwordIn" /></label>
		<input type="submit" name="loginbtn" value="Login"/>
		<input type="submit" name="registerbtn" value="Register"/>
	</form>
<!-- 	onclick="window.location.href='register.jsp'" -->
</body>
</html>