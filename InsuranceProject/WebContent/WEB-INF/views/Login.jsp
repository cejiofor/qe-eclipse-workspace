<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
<%-- 	<%@ include file="Navigation.html" %> --%>
	
	<p style="color:red;">${errorMessage}</p>
<%-- 	<a href="${pageContext.request.contextPath}/HomeServlet/showRegistration">Register Here</a> --%>
	<form action="${pageContext.request.contextPath}/HomeServlet/loginMember" method="post">
		<div>
			<label>Email: </label>
			<input name="userEmail" />
		</div>
		<div>
			<label>Password: </label>
			<input name="userPassword" type="password" />
		</div>
		<div>
			<table>
				<tr>
					<td><a href="${pageContext.request.contextPath}/HomeServlet/showRegistration">Register Here</a>
	
					<td><button type="submit" value="Login">Login</button></td>
				</tr>
			</table>
			
		</div>
	</form>
</body>
</html>