<%@page import="br.edu.ifsp.dsw1.business.LoginBusinessImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Form</title>
</head>
<body>
	<%
	boolean isLogged = new LoginBusinessImp().isLogged(request);
	if (isLogged) {
	%>
	<h2>Flight Form</h2>
	
	<a href="/airport/flight-form.jsp">Create flight</a>
	
	<a href="">Manage flights</a>
	
	<br> <br>
	
	<form action="/airport/frontController" method="post">
		<input type="text" id="command" name="command" value="FlightCommand" hidden="hidden">
		<input type="text" id="action" name="action" value="createFlight" hidden="hidden">
		
		<label for="flightNumber">Flight number:</label>
		<input type="number" id="flightNumber" name="flightNumber" min="0" step="1">
		
		<label for="company">Company:</label>
		<input type="text" id="company" name="company">
		
		<label for="time">Time:</label>
		<input type="text" id="time" name="time">
		
		<button type="submit">Register</button>
	</form>
	
	<%
	}
	else {
	%>
	<p>You don't have permission to access this page</p>
	<%
	}
	%>
</body>
</html>