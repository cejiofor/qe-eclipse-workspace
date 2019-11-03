<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration Form</title>
	<%	if (request.getParameter("sumbitregister") != null) {
			String userName = request.getParameter("username");
			String userPassword = request.getParameter("userPassword");
			String userPasswordTwo = request.getParameter("userPasswordTwo");
			String birthday = request.getParameter("birthday");
			
			if (!userPassword.equals(userPasswordTwo)) {
				request.setAttribute("error", "Passwords do not match. Please try again.");
				//request.getRequestDispatcher("Register.jsp").forward(request, response);
				response.sendRedirect("Register.jsp");
				
			} else {
				Cookie userCookie = new Cookie("username", userName);
				Cookie passwordCookie = new Cookie("password", userPassword);
			    Cookie birthdayCookie = new Cookie("birthday", birthday);
			    response.addCookie(userCookie);
				response.addCookie(passwordCookie);
				response.addCookie(birthdayCookie);
				request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
				// request.sendRedirect("LoginForm.jsp");
			}
		}
	%>

</head>
<body>
	<h1>Registration Form</h1>
	
	<% if (request.getAttribute("error") != null) {%>
    	<p style="color: red;"><%= request.getAttribute("error") %></p>
	<% } %>
	
	<form action="Register.jsp" method="post">
		<label>First Name:&nbsp;<input type="text" name="firstName" /></label>
		<br>
		<label>Last Name:&nbsp;<input type="text" name="lastName" /></label>
		<br>
		<label>Date of Birth:&nbsp;<input type="date" name="birthday" /></label>
		<br>
		<label>User Name:&nbsp;<input type="text" name="userName" /></label>
		<br>
		<label>Enter a Password:&nbsp;<input type="password" name="userPassword" /></label>
		<br>
		<label>Verify Password:&nbsp;<input type="password" name="userPasswordTwo" /></label>
		<br>
		<input type="submit" name="sumbitregister" value="Register" />
	</form>
</body>
</html>