<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Birthday Page</title>
<% 	//session.setAttribute("sessionVar", "newUser");
	//session.setAttribute("username", "testUser");
	Cookie[] cookies = request.getCookies();
	String bDayString = cookies[1].getValue();
%>


<% 	String userName = request.getParameter("userName");
	String userPassword = request.getParameter("userPassword");
	String userPasswordTwo = request.getParameter("userPasswordTwo");
// 	String bDayString = request.getParameter("birthday");
	LocalDate today = LocalDate.now();
// 	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy");
// 	LocalDate birthday = LocalDate.parse(bDayString, dtf);
	LocalDate birthday = LocalDate.parse(bDayString);
	long daysBetween = 0;
	if (birthday.getMonthValue() < today.getMonthValue()){
		daysBetween = ChronoUnit.DAYS.between(today, birthday.withYear(2020));
	} else{
		daysBetween = ChronoUnit.DAYS.between(today, birthday.withMonth(2019));
	}
	
	if (!userName.equals("testUser") || !userPassword.equals("testPassword")) {
		request.setAttribute("error", "Login unsuccessful.");
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	} 
	
	if (!userPassword.equals(userPasswordTwo)) {
		request.setAttribute("error", "Passwords do not match. Please try again.");
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}
		%>
</head>
<body>
	<h1>Welcome <%=userName %>! You have successfully logged in.</h1>
	<h1>Your Birthday is <%=birthday %></h1>
	<h1>Your Birthday is <%=daysBetween %> days away!</h1>
	
	
</body>
</html>