<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium Locators</title>
<link href="${pageContext.request.contextPath}/static/css/HiddenElements.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header>
		<h1 id="pageTitle">Selenium Hidden Elements Demonstration Page</h1>
		<%@ include file="Navigation.jsp" %>
	</header>
	<p>Display None Text:<span id="displayNone" style="display:inline;">
		Display None Span</span></p>	
	<p>Visibility Hidden Text:<span id="visibilityHidden" style="visibility:visible;">
		Display None Span</span></p>	
<!-- 	HIDDEN ELEMENTS STYLE -->
<!-- 	<p>Display None Text:<span id="displayNone" style="display:none;"> -->
<!-- 		Display None Span</span></p>	 -->
<!-- 	<p>Visibility Hidden Text:<span id="visibilityHidden" style="visibility:hidden;"> -->
<!-- 		Visibility Hidden</span></p> -->
	<p>If-Statement Text: <c:if test="${true}"><span id="ifStatement">
		If-Statement</span></c:if></p>
</body>
</html>