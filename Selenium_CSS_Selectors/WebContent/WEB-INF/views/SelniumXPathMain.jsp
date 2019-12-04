<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selenium XPath Main Page</title>
</head>
<body>
 	<header>
	 	<h1 id="pageTitle">Selenium XPath Demonstration - Main Page</h1>
		<%@ include file="Navigation.html" %>
		<form action="HomeServlet" method="post">
			<input type="text" name="searchInput" placeholder="Search" />
			<input type="submit" value="Search" />
		</form>
	</header>
	<div class="divClass1">
		<ul>
			<li class="liClass" title="ul1li1">div1 ul1 li1</li>
			<li class="liClass" title="ul1li2">div1 ul1 li2</li>
		</ul>
		<ul>
			<li class="liClass" title=ul2li1>div1 ul2 li1</li>
			<li class="liClass" title=ul2li2>div1 ul2 li2</li>
		</ul>
	</div>
	<div id="div2" class="divClass1">
		<div class="divClass2">
			<!-- The mathematical expression returns a random long greater than or 
			equal to 0 and less than or equal to 999 -->
			<p class="pClass1" id="pId${Math.round((Math.random() * 999))}">div2 div1 p1</p>
			<p class="pClass2">div2 div1 p2</p>
		</div>
		<div class="divClass2">
			<p class="pClass1 pClass3">div2 div2 p1</p>
			<p class="pClass2">div2 div2 p2</p>
		</div>
	</div>
	<%@ include file="Footer.html" %>
</body>
</html>