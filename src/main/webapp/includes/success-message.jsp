<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Message</title>
</head>
<body>
	<%
	String success = (String) request.getAttribute("success");
	
	if (success != null) {
	%>

	<div class="container mt-3">
		<div class="alert alert-success d-flex align-items-center" role="alert">
			<div>
				<span id="success-message"><%= success %></span>
			</div>
		</div>
	</div>

	<%
	}
	%>
</body>
</html>