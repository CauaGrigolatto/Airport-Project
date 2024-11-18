<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="br.edu.ifsp.dsw1.business.*"%>
<%@ page import="org.apache.commons.collections.*" %>
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
	<%
	boolean isLogged = new LoginBusinessImp().isLogged(request);
	if (isLogged) {
		
		List<FlightData> flights = new FlightBusinessImp().getAllFlights();
		
	%>
	<h2>Manage Flights</h2>
	
	<a href="/airport/flight-form.jsp">Create flight</a>
	
	<a href="/airport/manage-flights.jsp">Manage flights</a>
	
	<table>
		<thead>
			<tr>
				<th>Flight number</th>
				<th>Company</th>
				<th>Time</th>
			</tr>
		</thead>
		
		<tbody>
			<%
			if (CollectionUtils.isEmpty(flights)) {
				out.println("<tr>");
		    	out.println("<td colspan='3' style='text-align:center;'>N�o existem voos cadastrados :(</td>");
			    out.println("</tr>");
			}
			else {				
				for (FlightData flight : flights) {
					out.println("<tr>");
					out.println("<td>" + flight.getFlightNumber() + "</td>");
					out.println("<td>" + flight.getCompany() + "</td>");
					out.println("<td>" + flight.getTime() + "</td>");
					out.println("</tr>");
				}
			}
			
			%>
		</tbody>
	</table>
	
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