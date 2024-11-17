<%@page import="br.edu.ifsp.dsw1.business.LoginBusinessImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	boolean isLogged = new LoginBusinessImp().isLogged(request);
	if (isLogged) {
	%>
	<h2>Home page</h2>
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