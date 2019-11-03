<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" import="com.perscholas.jsp_actions.Student,
	java.time.LocalDateTime, java.time.format.DateTimeFormatter,
	java.util.Map, java.util.HashMap"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8" />
<%-- 	 <%@ page isELIgnored ="true"%>  --%>
	<title>Expressions</title>
		<!-- Create some beans and set values to implicit objects to demonstrate 
		Expression Language in the body of the page -->
		<% Map<String, Student> studentMap = new HashMap<>(); %>
		
		<!-- We can use jsp tags or the request.setAttribute() method to assign 
		values/objects to the implicit objects for retrieval in the body of the page -->
		<jsp:useBean id="student1" class="com.perscholas.jsp_actions.Student" />
		<jsp:setProperty property="name" name="student1" value="Jane Doe"/>
		<jsp:setProperty property="password" name="student1" value="jane1234"/>
		<jsp:setProperty property="course" name="student1" value="QEA"/>
		<% studentMap.put("Jane", student1); %>
		
		<jsp:useBean id="student2" class="com.perscholas.jsp_actions.Student" />
		<jsp:setProperty property="name" name="student2" value="John Doe"/>
		<jsp:setProperty property="password" name="student2" value="john1234"/>
		<jsp:setProperty property="course" name="student2" value="DE"/>
		<% studentMap.put("John", student2); %>

		<% 
			session.setAttribute("currentUser", "James");
			request.setAttribute("datetime", LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("MMM d, yyyy h:mm a")));
			request.setAttribute("studentMap", studentMap);
		%>
</head>
<body>
	<h1>Expressions</h1>
	<!-- Retrieves a student name from a Student bean. The prefix "pageScope" is
		optional. -->	
	<p>Student 1: ${pageScope.student1.name}</p>
	<!-- Retrieves a student name from a map -->
	<p>Student 2: ${studentMap.get("John").name}</p>
	<!-- Retrieves the current user from the session implicit object using square
               bracket notation. The prefix "sessionScope" is optional. -->
	<p>Current User: ${sessionScope["currentUser"]}</p>
	<!--  Retrieves the date and time from the request implicit object. The prefix
		requestScope is optional. -->
	<p>Date and Time: ${requestScope.datetime}</p>
</body>