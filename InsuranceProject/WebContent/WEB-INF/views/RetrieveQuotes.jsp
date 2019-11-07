<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,  com.perscholas.models.*, com.perscholas.dao.*" %>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Quotes</title>
</head>
<body>
	<h1>Retrieve Quotes</h1>

	<table>
		<tr>
			<th>Quote No.</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
			<th>Premium</th>
			<th>Action</th>
		</tr>
		<% 
			HomeQuotesDAO hqdao = new HomeQuotesDAO();
			Boolean update = hqdao.addHomeQuotes();
			List<HomeQuote> homeQuoteList = hqdao.getHomeQuotes();
			request.setAttribute("homeQuoteList", homeQuoteList);
		
		%>
<!-- 		//With more time: -->
<!-- 		Get a list of all of the data in the HomeQuotes table with the home and quote information -->
<!-- 		Loop over a list of the data, looking for objects where userId matches the userId from the currentUser attribute -->
<!-- 		Add e -->

		<c:forEach items="${homeQuoteList}" var="homeQuote">
			<tr>
				<td>${homeQuote.quoteId}</td>
				<td>${homeQuote.address1}</td>
				<td>${homeQuote.city}</td>
				<td>${homeQuote.state}</td>
				<td>${homeQuote.zip}</td>
				<td>${homeQuote.monthlyPremium}</td>
				<td>
					<!-- Switch statement for table end, depends on user status-->
					<!-- Outer Condition check to see if logged in member created event -->
					<c:choose>
						<%-- Allow creators to delete event --%>
						<c:when test = "${homeQuote.active}">
			            	<a href="${pageContext.request.contextPath}/HomeServlet/cancel">Cancel</a>
			         	</c:when>
			         	<c:otherwise>
							<p>Cancelled</p>
						</c:otherwise>
		      		</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="window.location.href='${pageContext.request.contextPath}/HomeServlet/showWelcome'" value="Back to Home Page">Back to Home Page</button>
	
	
</body>
</html>