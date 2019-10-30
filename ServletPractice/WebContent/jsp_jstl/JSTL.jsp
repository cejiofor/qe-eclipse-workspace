<%@ page language="java" contentType="text/html, charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8" />
	<title>JSTL Page</title>
</head>
<body>
	<h1>JSTL Page</h1>
	
	<%-- <c:out> examples. Note that you can include a default value between the
		tags if no value is found by the web app. --%>
	<h2><c:out value="Hello Per Scholas!">missing value</c:out></h2>
	
	<% request.setAttribute("Message", "Hello Platform!"); %>
	<h2><c:out value="${Message}">missing value</c:out></h2>
	
	<%-- <c:set> and <c:if> examples --%>
	<c:set var="grade" scope="page" value="85"/>
	<c:if test="${grade >= 70}">Congrats! You passed.</c:if>
	<c:remove var="grade"/>
	
	<!-- The attribute "grade" is now removed so the default value will be displayed. -->
	<p>Default value: <c:out value="${grade}">missing grade</c:out></p>
	
	<%-- The following lines of code demonstrate the <c:choose> tag used along with
	an HTML form and <c:when> and <c:otherwise> tags to choose between course input.
	These tags function similar to if-else or switch blocks. The first/next line 
	sets the parameter "submit" to false so that the <c:if> tag condition fails unless 
	the form is submitted.--%>
	<c:set var="submit" scope="page" value="false"></c:set>
	<p style="text-decoration: underline;">Course Form</p>
	<form method="post">
		<p>Enter Course: <input type="text" name="course" /></p>
		<!-- The "submit" parameter is set to true when the form is submitted. -->
		<input type="hidden" name="submit" value="true" />
		<input type="submit" name="submitCourse" value="Submit Course" />
	</form>
	
	<c:if test="${param.submit}">
		<c:choose>
			<c:when test="${param.course.equals('ASM')}">
				<c:out value="Course Name: Application Support Management" />
			</c:when>
			<c:when test="${param.course.equals('DE')}">
				<c:out value="Course Name: Data Engineering" />
			</c:when>
			<c:when test="${param.course.equals('QEA')}">
				<c:out value="Course Name: Quality Engineering & Assurance" />
			</c:when>
			<c:when test="${param.course.equals('')}">
				<c:out value="" />
			</c:when>
			<c:otherwise>Course not listed.</c:otherwise>
		</c:choose>
	</c:if>
	
	<%-- Here is an example of the <c:import> tag. It imports the entire contents of the 
	"Courses.html" file into the variable "courseList" --%>
	<p style="text-decoration: underline;">Content from Courses.html:</p>
	<c:import var="courseList" url="Courses.html"></c:import>
	<c:out value="${courseList}" />

	<% String[] courses = 
		{"Application Support Management", "Data Engineering", 
		"Quality Engineering and Assurance"};
		request.setAttribute("courses", courses);%>
	<p style="text-decoration: underline;">Course List</p>
	<c:forEach items="${courses}" var="c">
		<p><c:out value="${c}"></c:out></p>
	</c:forEach>
	
	<%-- In the next example, a string is split based on a delimiter and the 
	resulting elements are looped through and printed using the <c:forTokens> tag --%>
	<p style="text-decoration: underline;">Course List (short names):</p>
	<c:forTokens items="ASM,DE,QEA" delims="," var="shortName">
		<p><c:out value="${shortName}" /></p>
	</c:forTokens>
</body>