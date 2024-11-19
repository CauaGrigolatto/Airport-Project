package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.business.FlightBusiness;
import br.edu.ifsp.dsw1.business.FlightBusinessImp;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FlightCommand implements Command {
	private static final FlightBusiness flightBusiness = new FlightBusinessImp();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			
			if ("createFlight".equals(action)) {
				return createFlight(request);
			}
			else if ("updateFlight".equals(action)) {
				return updateFlight(request);
			}
			
			return "/home.jsp";
		}
		catch(Throwable t) {
			System.out.println("error execute " + t);
			request.setAttribute("error", t.getMessage());
			return (String) request.getAttribute("targetErrorPage");
		}		
	}

	private String createFlight(HttpServletRequest request) throws Throwable {
		try {			
			FlightData flight = flightBusiness.getByRequest(request);
			flightBusiness.insert(flight);
			return "/flight-form.jsp";
		}
		catch(Throwable t) {
			System.out.println("error createFlight " + t);
			request.setAttribute("targetErrorPage", "/flight-form.jsp");
			throw t;
		}
	}
	
	private String updateFlight(HttpServletRequest request) throws Throwable {
		try {
			FlightData flight = flightBusiness.getFlightByNumberInRequest(request);
			flightBusiness.updateFlight(flight);
			return "/manage-flights.jsp";
		}
		catch(Throwable t) {
			System.out.println("error updateFlight " + t);
			request.setAttribute("targetErrorPage", "/manage-flights.jsp");
			throw t;
		}
	}
}
