<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Quotes</title>
</head>
<body>
	<h1> Get A Quote!</h1>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/newQuote" method="post">
		<table style="width:50%;">
		<tr>
			<td><label>Address 1: </label></td>
			<td><input name="address1" /></td>
		</tr>
		<tr>
			<td><label>Address 2: </label></td>
			<td><input name="address2" /></td>
		</tr>
		<tr>
			<td><label>City: </label></td>
			<td><input name="city" /></td>
		</tr>
		<tr>
			<td><label>State: </label></td>
			<td><input name="state" /></td>
		</tr>
		<tr>
			<td><label>Zip: </label></td>
			<td><input name="zip" type="number" /></td>
		</tr>
		<tr>
			<td><label>Year Built: </label></td>
			<td><input name="yearBuilt" type="number" /></td>
		</tr>
		<tr>
			<td><label>Home Value: </label></td>
			<td><input name="homeValue" type="number" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Get New Quote" /></td>
		</tr>
	</form>
</body>
</html>