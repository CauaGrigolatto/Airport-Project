package br.edu.ifsp.dsw1.business;

import br.edu.ifsp.dsw1.feedback.InvalidLoginException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Interface for handling user login-related operations, including creating and terminating sessions, 
 * checking if a user is logged in, and verifying the integrity of actions.
 * Provides methods for managing user authentication and session lifecycle.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */
public interface LoginBusiness {
	/**
     * Creates a new session for the user after validating their login credentials.
     * 
     * @param username the username of the user attempting to log in.
     * @param password the password of the user attempting to log in.
     * @param request the HTTP request containing session details.
     * @return the created HttpSession object.
     * @throws InvalidLoginException if the login credentials are invalid.
     */
	HttpSession createSessionByLogin(String username, String password, HttpServletRequest request) throws InvalidLoginException;
	
	/**
     * Creates a session for the user if one does not already exist.
     * 
     * @param request the HTTP request containing session details.
     * @return the created or existing HttpSession object.
     */
	HttpSession createSession(HttpServletRequest request);
	
	 /**
     * Terminates the current session for the user, logging them out.
     * 
     * @param request the HTTP request containing session details.
     */
	void terminateSession(HttpServletRequest request);
	
	 /**
     * Checks if the user is currently logged in by verifying the existence of a valid session.
     * 
     * @param request the HTTP request containing session details.
     * @return true if the user is logged in, false otherwise.
     */
	boolean isLogged(HttpServletRequest request);
	
	/**
     * Verifies the integrity of the action being requested, ensuring that the user is authorized to perform it.
     * 
     * @param request the HTTP request containing session and action details.
     * @throws IllegalAccessException if the user is not authorized to perform the action.
     */
	void checkIntegrityOfAction(HttpServletRequest request) throws IllegalAccessException;
}
