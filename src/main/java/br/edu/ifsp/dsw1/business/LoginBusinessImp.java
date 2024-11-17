package br.edu.ifsp.dsw1.business;

import org.apache.commons.lang3.StringUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginBusinessImp implements LoginBusiness {
	private final String USERNAME = "admin";
	private final String PASSWORD = "admin";
	
	@Override
	public boolean validateLogin(String username, String password) {
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			if (USERNAME.equals(username) && PASSWORD.equals(password)) {
				return true;
			}
		}
		
		return false;
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
}
