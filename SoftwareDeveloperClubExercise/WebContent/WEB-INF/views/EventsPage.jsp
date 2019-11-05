<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Page</title>
</head>
<body>
	<h1>Events</h1>
<%-- 	<% --%>
// 		EventDAO edao = new EventDAO();
// 		List<Events> eventList = edao.getEvents();
// 		for(Event e:eventList){
			
// 		}
<%-- 	%> --%>
	<table>
		<tr>
			<th>Event ID</th>
			<th>Title</th>
			<th>Description</th>
			<th>Location</th>
			<th>Date Time</th>
			<th>Member ID</th>
		</tr>
		<c:forEach items="${eventList}" var="event">
			<tr>
<%-- 				<td>${event.eventId}</td> --%>
				<td>${event.title}</td>
				<td>${event.description}</td>
				<td>${event.location}</td>
				<td>${event.dateTime}</td>
<%-- 				<td>${event.memberId}</td> --%>
				<c:if test="${currentUser.memberId == event.eventId }">
					<a href="#">Delete</a>
				</c:if>
				<c:if test="${currentUser.memberId == event.eventId }">
					<a href="#">Delete</a>
				</c:if>
				<c:choose>
					<c:when test="${currentMember.memberId == event.memberId}">
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	
	<form action="${pageContext.request.contextPath}/HomeServlet/createEvent" method="post">
		<div>
			<label>Event Title: </label>
			<input name="title" />
		</div>
		<div>
			<label>Description: </label>
			<input name="description" />
		</div>
		<div>
			<label>Location: </label>
			<input name="location" type="password" />
		</div>
		<div>
			<label>Date &amp; TIme: </label>
			<input type="datetime-local" name="dateTime" />
		</div>
		<div>
			<input type="submit" value="Create Event" />
		</div>
	</form>
</body>
</html>