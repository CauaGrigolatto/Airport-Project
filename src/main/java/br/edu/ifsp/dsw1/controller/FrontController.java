package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifsp.dsw1.command.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The FrontController class serves as the central entry point for handling requests
 * in the system. It dispatches requests to the appropriate commands based on the
 * parameters in the request.
 * 
 * It uses the command pattern to delegate the processing of requests to specific
 * command classes and returns the appropriate page URL for forwarding.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */

@WebServlet("/frontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_COMMAND_PATH = "br.edu.ifsp.dsw1.command.";
	
	
	/**
     * Handles HTTP POST requests, processes the "command" parameter, 
     * creates an instance of the corresponding Command class, and executes it.
     * If a valid URL is returned, it forwards the request to that URL.
     * 
     * This method is used to delegate the request to the correct business logic
     * and provide the response to the client.
     * 
     * @param request  the HTTP request sent by the client
     * @param response the HTTP response to be sent to the client
     * @throws ServletException if the request could not be handled properly
     * @throws IOException if an I/O error occurs during request processing
     */
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String controllerClassString = (String) request.getParameter("command");
			Command controller = (Command) Class.forName(DEFAULT_COMMAND_PATH + controllerClassString).newInstance();
			String url = controller.execute(request, response);
			
			if (StringUtils.isNotBlank(url)) {				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
			
		}
		catch(Throwable t) {
			System.out.println("error doPost " + t);
			t.printStackTrace();
		}
	}
	
	/**
     * Handles HTTP GET requests by redirecting them to the doPost method. 
     * This is a convenience method for simplifying HTTP GET handling.
     * 
     * @param req the HTTP request sent by the client
     * @param resp the HTTP response to be sent to the client
     * @throws ServletException if the request could not be handled properly
     * @throws IOException if an I/O error occurs during request processing
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
