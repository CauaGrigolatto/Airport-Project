<%@page import="br.edu.ifsp.dsw1.business.LoginBusiness"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Default Page</title>
</head>
<body>
	<%
	boolean isLogged = new LoginBusiness().isLogged(request);
	if (isLogged) {
	%>
	
	<jsp:include page="<%= request.getAttribute("page") %>" />
	
	<%
	else {
	%>
	<p>You don't have permission to access this page.</p>
	<%
	}
	%>
</body>
</html>