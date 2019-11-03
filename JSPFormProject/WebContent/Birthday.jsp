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
<% 	
	Cookie[] cookies = request.getCookies();
	String username = null;
	String bDayString = null;
	
	for(Cookie c : cookies){
		if(c.getName().equals("username")){
			username = c.getValue();
		}
		if(c.getName().equals("birthday")){
			bDayString = c.getValue();
		}
	}
	
	LocalDate today = LocalDate.now();
	LocalDate birthday = LocalDate.parse(bDayString);
	long daysBetween = 0;
	int currentYear = today.getYear();
	
	if (birthday.withYear(currentYear).compareTo(today) < 0){
		daysBetween = ChronoUnit.DAYS.between(today, birthday.withYear(currentYear+1));
	} else{
		daysBetween = ChronoUnit.DAYS.between(today, birthday.withYear(currentYear));
	}
		%>
</head>
<body>
	<h1>Welcome <%=username %>! You have successfully logged in.</h1>
	<h1>Your Birthday is <%=birthday %></h1>
	<h1>Your Birthday is <%=daysBetween %> days away!</h1>
	
	
</body>
</html>