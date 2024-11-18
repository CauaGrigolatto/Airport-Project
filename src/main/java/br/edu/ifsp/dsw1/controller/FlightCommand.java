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
			
		}
		catch(Throwable t) {
			System.out.println("error execute " + t);
		}
		
		return "/home.jsp";			
	}

	private String createFlight(HttpServletRequest request) throws Throwable {
		try {			
			FlightData flight = flightBusiness.getByRequest(request);
			flightBusiness.insert(flight);
			return "/flight-form.jsp";
		}
		catch(Throwable t) {
			System.out.println("error createFlight " + t);
			throw t;
		}
	}
}
