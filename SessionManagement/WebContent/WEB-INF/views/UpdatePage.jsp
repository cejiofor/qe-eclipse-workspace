<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Management Exercise</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ProductServlet" method="post">
		<input type="hidden" name="productId" value="${product.getProductId()}"/>
		<label>Product Name:&nbsp;<input type="text" name="productName" /></label>
		<label>Product Description:&nbsp;<input type="text" name="productDescription"/></label>
		<br>
		<input type="submit" name="sumbit" value="sumbit" />
	</form>
</body>
</html>