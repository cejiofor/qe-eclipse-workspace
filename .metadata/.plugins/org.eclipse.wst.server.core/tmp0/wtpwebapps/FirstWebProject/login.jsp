<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>

<body>
    <section>
        <h1>Hello! Please login below.</h1>
    </section>
    <form action="/FirstWebProject/welcome.html">
    <!--  Set action to servlet, then use function in servlet to redirect to another page
    save variables from "GET" into a array, set and retrieve variables from -->
        <label for="userName">Username:</label>
            <input type="text" name="userName" />

        <label for="password">Password:</label>
            <input type="password" name="password" />
        <br />		

        <input id="submitForm" type="submit" value="Register" />
    </form>
    
    <section>
        <p><a href="register.jsp">Click here to register</a></p>
    </section>
            ​
</body>
</html>