<%@page import="br.edu.ifsp.dsw1.model.entity.FlightData"%>
<%@page import="br.edu.ifsp.dsw1.business.*"%>
<%@page import="org.apache.commons.collections.*" %>
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
	List<FlightData> flights = new FlightBusinessImp().getBoardingFlights();
	%>

	<h2>Boarding Flights</h2>
	
	<table>
		<thead>
			<tr>
				<th>Flight number</th>
				<th>Company</th>
				<th>Time</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			<%
			if (CollectionUtils.isEmpty(flights)) {
				out.println("<tr>");
		    	out.println("<td colspan='5' style='text-align:center;'>Não existem voos cadastrados :(</td>");
			    out.println("</tr>");
			}
			else {				
				for (FlightData flight : flights) {
					out.println("<tr>");
					out.println("<td>" + flight.getFlightNumber() + "</td>");
					out.println("<td>" + flight.getCompany() + "</td>");
					out.println("<td>" + flight.getTime() + "</td>");
					out.println("<td>" + flight.getState().getClass().getSimpleName() + "</td>");
					out.println("</tr>");
				}
			}
			
			%>
		</tbody>
	</table>
	
</body>
</html>