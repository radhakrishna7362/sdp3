<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>

<body>
<h1 align='center'>Admin Login</h1>
<span>Login Failed. Please Try Again</span>
<form action="/admin-login" method="POST">
<input type="text" id="userName" name="userName" placeholder="UserName">
<input type="password" id="password" name="password" placeholder="Password">
<input type="submit" value="Login">
</form>
</body>

</html>