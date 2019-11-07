<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h1>Welcome ${currentUser.firstName}</h1>
	
	<table>
		<tr>
			<td><button onclick="window.location.href='${pageContext.request.contextPath}/HomeServlet/getQuote'" value="Get New Quotes">Get New Quotes</button></td>
		</tr>
		<tr>
			<td><button onclick="window.location.href='${pageContext.request.contextPath}/HomeServlet/retrieveQuotes'" value="Retrieve Quotes">Retreive Quotes</button></td>
		</tr>
	</table>
</body>
</html>