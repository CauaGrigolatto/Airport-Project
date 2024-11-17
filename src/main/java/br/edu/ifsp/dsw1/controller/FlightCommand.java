package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FlightCommand implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if ("flightForm".equals(action)) {
			return getFlightForm();
		}
		
		return "/home.jsp";
	}
	
	private String getFlightForm() {
		return "/flight-form.jsp";
	}
}
