package br.edu.ifsp.dsw1.business;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifsp.dsw1.feedback.InvalidLoginException;
import br.edu.ifsp.dsw1.feedback.MessagesBundle;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Implementation of the LoginBusiness interface that handles user login operations,
 * session management, and access control.
 * This class provides functionality for authenticating users, creating and terminating sessions,
 * checking if a user is logged in, and ensuring that actions are authorized based on user login status.
 * 
 * @author Cauã Grigolatto Domingos
 * @version 1.0
 */

public class LoginBusinessImp implements LoginBusiness {
	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";
	
	/**
     * Creates a session for the user after validating their login credentials.
     * 
     * @param username the username provided by the user.
     * @param password the password provided by the user.
     * @param request the HTTP request object containing session details.
     * @return the created HttpSession object if the credentials are valid.
     * @throws InvalidLoginException if the provided login credentials are invalid.
     */
	@Override
	public HttpSession createSessionByLogin(String username, String password, HttpServletRequest request) throws InvalidLoginException {
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			if (USERNAME.equals(username) && PASSWORD.equals(password)) {
				return createSession(request);
			}
		}
		
		throw new InvalidLoginException(MessagesBundle.INVALID_LOGIN);
	}
	
	/**
     * Creates a new session for the user if one does not already exist.
     * 
     * @param request the HTTP request object containing session details.
     * @return the created HttpSession object.
     */
	@Override
	public HttpSession createSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("isLogged", "true");
		return session;
	}
	
	/**
     * Terminates the user's current session by invalidating it.
     * 
     * @param request the HTTP request object containing session details.
     */
	@Override
	public void terminateSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.setAttribute("isLogged", "false");
			session.invalidate();
		}
	}
	
	/**
     * Checks if the user is logged in by verifying the existence of a valid session.
     * 
     * @param request the HTTP request object containing session details.
     * @return true if the user is logged in, false otherwise.
     */
	@Override
	public boolean isLogged(HttpServletRequest request) {
		boolean isLogged = false;
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			isLogged = Boolean.parseBoolean((String) session.getAttribute("isLogged"));
		}
		
		return isLogged;
	}
	
	/**
     * Verifies if the user is logged in before allowing access to a requested action.
     * 
     * @param request the HTTP request object containing session details.
     * @throws IllegalAccessException if the user is not logged in and the action is denied.
     */
	@Override
	public void checkIntegrityOfAction(HttpServletRequest request) throws IllegalAccessException {
		if (!isLogged(request)) throw new IllegalAccessException(MessagesBundle.ACTION_DENIED_BY_PERMISSIONS);
	}
}
