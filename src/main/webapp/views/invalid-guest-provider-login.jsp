<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Guest Provider Login</title>
</head>

<body>
<h1 align='center'>Guest Provider Login</h1>
<span>${msg}</span>
<form action="/guest-provider-login" method="POST">
<input type="text" id="userName" name="userName" placeholder="UserName">
<input type="password" id="password" name="password" placeholder="Password">
<input type="submit" value="Login">
</form>
</body>

</html>