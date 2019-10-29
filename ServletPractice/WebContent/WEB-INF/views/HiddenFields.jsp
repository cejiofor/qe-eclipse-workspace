<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hidden Fields</title>
</head>
<body>
	<h1>Hidden Fields</h1>
	<form action="HiddenFieldsServlet" method="post">
		<input type="hidden" name="userId" value="${currentUser.userId}" />
		<input type="text" name="name" value="${currentUser.name}" />
		<input type="hidden" name="email" value="${currentUser.email}" />
		<input type="submit" value="Submit Hidden Info" />
	</form>
</body>
</html>