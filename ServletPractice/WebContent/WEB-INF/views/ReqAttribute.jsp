<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Attribute Page</title>
</head>
<body>
	<h1>Request Attribute Page</h1>
	<fieldset>
		<legend>Color Red</legend>
		<p>This is the color attribute that was set in the servlet. Expression 
		Language (EL) will be used to retrieve the value. Since the object is a 
		String type we don't need to specify any class fields to retrieve the 
		value which should be red:</p>
		<p>color: ${color}</p> 
	</fieldset>
	<fieldset>
		<legend>List of Colors</legend>
		<p>The following set of lines will come from iterating over a list of 
		String objects included in the list "colors". The JSTL c:forEach tag will 
		be used to iterate through the list (remember to include the JSTL 
		dependency in your project) and EL will be used to display each item in the 
		list:</p>
		<c:forEach items="${colors}" var="color">
			<p>${color}</p>
		</c:forEach>
	</fieldset>
	<fieldset>
		<legend>Student</legend>
		<p>This example will display a Student object passed from the servlet and 
		utilize EL to specify which student property/attribute to be displayed. 
		Note that when EL is used, the object's attributes can be retrieved using 
		dot (".") notation which bypasses the need to use accessor/getter methods.</p>
		<p>Student ID: ${student1.studentId}</p>
		<p>Student Name: ${student1.name}</p>
	</fieldset>
</body>
</html>