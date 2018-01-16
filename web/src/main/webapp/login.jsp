<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="/login">
    <label for="userName">Login:</label>
    <input type="text" id="userName" name="userName">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <input type="submit" value="login" name="login"/>
</form>
</body>
</html>