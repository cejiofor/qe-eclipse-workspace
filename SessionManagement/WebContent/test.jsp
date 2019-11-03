<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.perscholas.products.Product"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<% Product product = (Product) request.getAttribute("product");  %>
	
	<form action="${pageContext.request.contextPath}/ProductServlet" method="POST">
	<table style="width:50%">
		<tr>
			<td><label>Product Name:</label></td>
			<td><input type="text" name="productName" placeholder="Name"/></td>
		</tr>
		<tr>
			<td><label>Product Description:</label></td>
			<td><input type="text" name="productDescription" placeholder="Description"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="submitLogin" value="Submit"></td>
			<td><input type="hidden" name="productId" value="${product.productId}"/></td>
		</tr>
	</table>
	</form>
</body>
</html>