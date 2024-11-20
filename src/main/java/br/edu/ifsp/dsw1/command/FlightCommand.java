package br.edu.ifsp.dsw1.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.business.FlightBusiness;
import br.edu.ifsp.dsw1.business.FlightBusinessImp;
import br.edu.ifsp.dsw1.business.LoginBusiness;
import br.edu.ifsp.dsw1.business.LoginBusinessImp;
import br.edu.ifsp.dsw1.model.entity.FlightData;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles actions related to flights, such as flight creation and updates.
 * This class processes HTTP requests for flight management and delegates the actions 
 * to business logic classes to perform the necessary operations.
 * 
 * The class uses the command pattern to decide which action to execute based on 
 * the request parameters.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */

public class FlightCommand implements Command {
	private static final FlightBusiness flightBusiness = new FlightBusinessImp();
	private static final LoginBusiness loginBusiness = new LoginBusinessImp();
	
	/**
     * Executes the requested action based on the "action" parameter 
     * and returns the corresponding page to be dispatched by the FrontController.
     * 
     * This method delegates the request depending on the action specified 
     * in the request parameter.
     * 
     * @param request the HTTP request sent by the FrontController
     * @param response the HTTP response to be sent to the FrontController
     * @return the page to be dispatched after processing the request
     * @throws ServletException if a servlet-specific error occurs during request processing
     * @throws IOException if an I/O error occurs during request processing
     */
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
			
			return "/index.jsp";
		}
		catch(Throwable t) {
			System.out.println("error execute " + t);
			request.setAttribute("error", t.getMessage());
			return (String) request.getAttribute("targetErrorPage");
		}		
	}
	
	/**
     * Creates a new flight using parameters from the request.
     * This method performs flight creation by validating the action, 
     * creating a FlightData object from the request, and inserting it into the database.
     * 
     * @param request the HTTP request containing the flight data to be created
     * @return the page to be displayed after creating the flight
     * @throws IllegalAccessException if the action is not allowed due to user session state
     * @throws Throwable if any other exception occurs during the flight creation process
     */
	private String createFlight(HttpServletRequest request) throws IllegalAccessException, Throwable {
		try {
			loginBusiness.checkIntegrityOfAction(request);
			
			FlightData flight = flightBusiness.getByRequest(request);
			flightBusiness.insert(flight);
			return "/flight-form.jsp";
		}
		catch(IllegalAccessException e) {
			request.setAttribute("targetErrorPage", "/index.jsp");
			throw e;
		}
		catch(Throwable t) {
			System.out.println("error createFlight " + t);
			request.setAttribute("targetErrorPage", "/flight-form.jsp");
			throw t;
		}
	}
	
    /**
     * Updates the details of an existing flight.
     * This method updates a flight by retrieving the flight data from the request 
     * and calling the business logic to apply the changes.
     * 
     * @param request the HTTP request containing the updated flight data
     * @return the page to be displayed after updating the flight
     * @throws IllegalAccessException if the action is not allowed due to user session state
     * @throws Throwable if any other exception occurs during the flight update process
     */
	private String updateFlight(HttpServletRequest request) throws IllegalAccessException, Throwable {
		try {
			loginBusiness.checkIntegrityOfAction(request);
			
			FlightData flight = flightBusiness.getFlightByNumberInRequest(request);
			flightBusiness.updateFlight(flight);
			return "/manage-flights.jsp";
		}
		catch(IllegalAccessException e) {
			request.setAttribute("targetErrorPage", "/index.jsp");
			throw e;
		}
		catch(Throwable t) {
			System.out.println("error updateFlight " + t);
			request.setAttribute("targetErrorPage", "/manage-flights.jsp");
			throw t;
		}
	}
}
