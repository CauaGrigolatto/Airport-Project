<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="/airport/frontController" method="post">
		<input type="text" id="command" name="command" value="LoginCommand" hidden="hidden">
		<input type="text" id="action" name="action" value="login" hidden="hidden">
	
		<label for="username">Username:</label>
		<input type="text" id="username" name="username">
		
		<label for="password">Password:</label>
		<input type="password" id="password" name="password">
		
		<button type="submit">Login</button>
	</form>
</body>
</html>