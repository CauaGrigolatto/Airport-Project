<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="br.edu.ifsp.dsw1.business.*"%>
<%@page import="org.apache.commons.collections.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Flights</title>
</head>
<body>
	<jsp:include page="/includes/navbar.html"></jsp:include>

	<%
	boolean isLogged = new LoginBusinessImp().isLogged(request);
	if (isLogged) {
		
		List<FlightData> flights = new FlightBusinessImp().getAllFlights();
		
	%>
	<div class="container mt-5">
		<h2 class="text-center mb-4">Manage Flights</h2>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead class="table-dark">
					<tr>
						<th>Flight Number</th>
						<th>Company</th>
						<th>Time</th>
						<th>State</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
                    if (CollectionUtils.isEmpty(flights)) {
                        out.println("<tr>");
                        out.println("<td colspan='5' class='text-center'>Não existem voos cadastrados :(</td>");
                        out.println("</tr>");
                    } else {                
                        for (FlightData flight : flights) {
                            out.println("<tr>");
                            out.println("<td>" + flight.getFlightNumber() + "</td>");
                            out.println("<td>" + flight.getCompany() + "</td>");
                            out.println("<td>" + flight.getTime() + "</td>");
                            out.println("<td>" + flight.getState().getClass().getSimpleName() + "</td>");
                            out.println("<td><a href='/airport/frontController?command=FlightCommand&action=updateFlight&flightNumber=" + flight.getFlightNumber() + "' class='btn btn-primary btn-sm'>Update Flight</a></td>");
                            out.println("</tr>");
                        }
                    }
                    %>
				</tbody>
			</table>
		</div>
	</div>

	<%
	
	
	%>


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