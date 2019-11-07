<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Update Page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/MainServlet/updateProfile" method="post">
		<div>
			<input name="userId" type="hidden" value="${currentUser.userId}"/>
		</div>
		<div>
			<label>Name: </label>
			<input name="userName" value="${currentUser.userName}"/>
		</div>
		<div>
			<label>Password: </label>
			<input name="password" type="password" value="${currentUser.password}" />
		</div>
		<div>
			<input type="submit" value="Update Profile" />
		</div>
	</form>
	<a href="${pageContext.request.contextPath}/MainServlet/showProfile">Back to Profile</a>
</body>
</html>