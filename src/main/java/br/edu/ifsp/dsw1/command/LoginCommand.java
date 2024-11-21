package br.edu.ifsp.dsw1.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.business.LoginBusiness;
import br.edu.ifsp.dsw1.business.LoginBusinessImp;
import br.edu.ifsp.dsw1.feedback.InvalidLoginException;
import br.edu.ifsp.dsw1.feedback.MessagesBundle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Handles login and logout actions for the system.
 * This class processes HTTP requests related to user authentication.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */

public class LoginCommand implements Command {
	private static LoginBusiness loginBusiness = new LoginBusinessImp();
	
	/**
     * Executes the requested action based on the "action" parameter 
     * and returns the corresponding page to be dispatched.
     * 
     * @param request the HTTP request from the FrontController
     * @param response the HTTP response to the FrontController
     * @return the page to be dispatched by the FrontController
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs during request processing
     */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = (String) request.getParameter("action");
			
			if ("login".equals(action)) {
				return login(request);
			}
			else if ("logout".equals(action)) {
				return logout(request);
			}
			
		}
		catch(Throwable t) {
			request.setAttribute("error", t.getMessage());
			return (String) request.getAttribute("targetErrorPage");
		}
		
		return "/index.jsp";
	}
	
	/**
     * Authenticates a user based on the provided username and password.
     * Creates a session for the user if the authentication is successful.
     * 
     * @param request the HTTP request containing the login credentials
     * @return the page to navigate after a successful login
     * @throws InvalidLoginException if the username or password is invalid
     */
	private String login(HttpServletRequest request) throws InvalidLoginException {		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			loginBusiness.createSessionByLogin(username, password, request);
			request.setAttribute("success", MessagesBundle.LOGGED_SUCCESSFULLY);
			return "/manage-flights.jsp";
		}
		catch(Throwable t) {
			System.out.println("error login " + t);
			request.setAttribute("targetErrorPage", "/index.jsp");
			throw t;
		}
	}
	
	/**
     * Terminates the current user session, effectively logging the user out.
     * 
     * @param request the HTTP request to handle the logout action
     * @return the page to navigate after logging out
     */
	private String logout(HttpServletRequest request) {
		loginBusiness.terminateSession(request);
		return "/index.jsp";
	}
}
