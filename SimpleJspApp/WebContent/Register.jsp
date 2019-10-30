<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration Form</title>
	<%	String error = null;	
		if (request.getParameter("register") != null) {
			String userPassword = request.getParameter("userPassword");
			String userPasswordTwo = request.getParameter("userPassword2");
// 			if (!userPassword.equals(userPasswordTwo)) {
// 				request.setAttribute("error", "Passwords do not match. Please try again");
// 				request.getRequestDispatcher("Register.jsp").forward(request, response);
// 			}
			if (userPassword.equals(userPasswordTwo)) {
				response.sendRedirect("Register.jsp");
			} else {
				error = "Passwords do not match. Please try again.";
			}
		}
		
		Cookie userCookie = new Cookie("username", request.getParameter("username"));
	    Cookie birthdayCookie = new Cookie("birthday", request.getParameter("birthday"));
	    
	    response.addCookie(userCookie);
	    response.addCookie(birthdayCookie);
	    
	    request.getRequestDispatcher("Birthday.jsp").forward(request,response);
		response.addCookie(userCookie);
		response.addCookie(birthdayCookie);
	%>

</head>
<body>
	<h1>Registration Form</h1>
	
	<% if (error != null) {%>
		<p style="color: red;"><%= error %></p>
	<% } %>
	
	<form action="Birthday.jsp" method="post">
		<label>First Name:&nbsp;<input type="text" name="firstName" /></label>
		<br>
		<label>Last Name:&nbsp;<input type="text" name="lastName" /></label>
		<br>
		<label>Date of Birth:&nbsp;<input type="date" name="DOB" /></label>
		<br>
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<br>
		<label>Enter a Password:&nbsp;<input type="password" name="userPassword" /></label>
		<br>
		<label>Verify Password:&nbsp;<input type="password" name="userPasswordTwo" /></label>
		<br>
		<input type="submit" name="register" value="Register" />
	</form>
</body>
</html>