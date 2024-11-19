package br.edu.ifsp.dsw1.business;

import org.apache.commons.lang3.StringUtils;

import br.edu.ifsp.dsw1.exception.InvalidLoginException;
import br.edu.ifsp.dsw1.exception.MessagesBundle;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginBusinessImp implements LoginBusiness {
	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";
	
	@Override
	public HttpSession createSessionByLogin(String username, String password, HttpServletRequest request) throws InvalidLoginException {
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			if (USERNAME.equals(username) && PASSWORD.equals(password)) {
				return createSession(request);
			}
		}
		
		throw new InvalidLoginException(MessagesBundle.INVALID_LOGIN);
	}
	
	@Override
	public HttpSession createSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("isLogged", "true");
		return session;
	}
	
	@Override
	public void terminateSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.setAttribute("isLogged", "false");
			session.invalidate();
		}
	}
	
	@Override
	public boolean isLogged(HttpServletRequest request) {
		boolean isLogged = false;
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			isLogged = Boolean.parseBoolean((String) session.getAttribute("isLogged"));
			return isLogged;
		}
		
		return isLogged;
	}
	
	@Override
	public void checkIntegrityOfAction(HttpServletRequest request) throws IllegalAccessException {
		if (!isLogged(request)) throw new IllegalAccessException(MessagesBundle.ACTION_DENIED_BY_PERMISSIONS);
	}
}
