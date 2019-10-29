<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cookie Page</title>
</head>
<body>
	<h1>Cookie Page</h1>
	<p>Current User: ${cookie.currentUser.value}</p>
	<p>User Location: ${cookie.userLocation.value}</p>
	<ul>
		<c:forEach items="${cookie}" var="cookieVar">
			<li>
				<c:out value="${cookieVar.key}"/>:
				Object=<c:out value="${cookieVar.value}"/>,
				Value=<c:out value="${cookieVar.value.value}"/>
			</li>
		</c:forEach>
	</ul>
	<a href="${pageContext.request.contextPath}/secondCookiePage">Second Cookie Page</a>
</body>