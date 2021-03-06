<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html lang="en">
​
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">

</head>
​
<body>
    <section>
        <h1>Hello! Please register your account below.</h1>
    </section>
    <form action="/FirstWebProject/registered.jsp" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" />
        <br /><br />
        <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" />
        <br /><br />
        <label for="emailAddress">Email Address:</label>
            <input type="email" name="emailAddress" />
        <br /><br />
        <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" name="dateOfBirth" />
        <br /><br />
        
        <label for="gender">Gender:</label>
        <br />
        <input type="radio" name="gender" value="Female"> Female
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Other"> Other
        <br /><br />

        <label for="userName">Enter a User Name:</label>
            <input type="text" name="userName" />
        <br /><br />

        <label for="password">Enter a strong password:</label>
            <input type="password" name="password" />
        <br /><br />

        <label for="passwordRepeat">Please verify password:</label>
            <input type="password" name="passwordRepeat" />
        <br /><br />
        
        <input id="submitForm" type="submit" value="Register" />
    </form>
​
</body>
​
</html>