<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String error = (String) request.getAttribute("error");
	
	if (error != null) {
	%>

	<div class="container mt-3">
		<div class="alert alert-danger d-flex align-items-center" role="alert">
			<div>
				<span id="error-message"><%= error %></span>
			</div>
		</div>
	</div>

	<%
	}
	%>
</body>
</html>