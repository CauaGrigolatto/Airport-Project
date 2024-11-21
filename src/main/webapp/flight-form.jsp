<%@page import="br.edu.ifsp.dsw1.business.LoginBusinessImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Form</title>
</head>
<body>
	<jsp:include page="/includes/navbar.html" />
	
	<jsp:include page="/includes/error-message.jsp" />
	<jsp:include page="/includes/success-message.jsp" />

	<%
	boolean isLogged = new LoginBusinessImp().isLogged(request);
	if (isLogged) {
	%>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-8 col-lg-6">
				<div class="card shadow-sm">
					<div class="card-body">
						<h5 class="card-title text-center mb-4">Flight Form</h5>
						<form action="/airport/frontController" method="post">

							<input type="text" id="command" name="command" value="FlightCommand" hidden> 
							
							<input type="text" id="action" name="action" value="createFlight" hidden>

							<div class="mb-3">
								<label for="flightNumber" class="form-label">Flight
									Number:</label> <input class="form-control"
									id="flightNumber" name="flightNumber" 
									type="number" min="1" step="1"
									placeholder="Enter flight number" required>
							</div>

							<div class="mb-3">
								<label for="company" class="form-label">Company:</label> <input
									type="text" class="form-control" id="company" name="company"
									placeholder="Enter company name" required>
							</div>

							<div class="mb-3">
								<label for="time" class="form-label">Time:</label> <input
									type="datetime-local" class="form-control" id="time"
									name="time" required>
							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-success">Submit
									Flight</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%
	}
	else {
	%>
	<div class="mt-5">
        <h1 class="text-center">You don't have permission to access this page</h1>
	</div>
	<%
	}
	%>
</body>
</html>