<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Servlet Page Intro</title>
</head>
<body>
	<h1>Java Servlet Page Intro</h1>
	<% String s = "John"; %>
	<h2>Welcome <% out.print( s ); %></h2>
</body>
</html>