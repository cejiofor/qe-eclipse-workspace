<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.perscholas.javaserver.*, java.util.List, java.util.ArrayList, java.time.LocalDateTime, java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<% List<Course> courseList = (ArrayList<Course>) request.getAttribute("courseList"); %>
</head>
<body>
	<h1>Hello!</h1>
	<p>Good Morning! Today is:</p>
	<% LocalDateTime current = LocalDateTime.now(); %>
	<% out.print(current.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a"))); %>

	<h1>School Name: ${schoolName}</h1>
	
	<table style="width:50%">
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Course Description</th>
		</tr>
		<% 
			for(Course c:courseList){
				out.print(c.getCourseId());
				out.print(c.getName());
				out.print(c.getDescription());
			}
		
			
		
		%>
	</table>
	
</body>
</html>