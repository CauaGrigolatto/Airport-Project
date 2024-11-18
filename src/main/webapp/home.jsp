<%@page import="br.edu.ifsp.dsw1.business.LoginBusinessImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<jsp:include page="/includes/navbar.html"></jsp:include>

	<%
	boolean isLogged = new LoginBusinessImp().isLogged(request);
	if (isLogged) {
	%>
	<h2>Home Page</h2>
	
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