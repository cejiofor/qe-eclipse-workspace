<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adds</title>
</head>
<body>
	<h1>Adds</h1>
	<h3>Add Form</h3>
	<form action="${pageContext.request.contextPath}/createAdd" method="post">
		<div>
			<label for="name">Name</label>
			<div>
				<form:input path="name"/>
				<p style="color:red;"><form:errors path="name" class="error"/></p>
			</div>
		</div>
		<div>
			<label for="price">Price</label>
			<div>
				<form:input path="price"/>

				<p style="color:red;"><form:errors path="price" class="error"/></p>
			</div>
		</div>
		<input type="submit" value="Add" />
	</form>
	<legend>Add List</legend>
	<table>
		<tr>
			<th>Add ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${allAdds}" var="add">
			<tr>
				<td>${add.addId}</td>
				<td>${add.name}</td>
				<td>${add.price}</td>
				<td>${add.available}</td>
				<td>
					<c:choose>
						<c:when test="${add.getAvailable()}">
							<a href="${pageContext.request.contextPath}/cancelAdd/${add.addId}">Cancel</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/orderAdd/${add.addId}">Order</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>