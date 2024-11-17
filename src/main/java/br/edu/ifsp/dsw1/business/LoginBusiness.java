package br.edu.ifsp.dsw1.business;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public interface LoginBusiness {
	boolean validateLogin(String username, String password);
	HttpSession createSession(HttpServletRequest request);
	void terminateSession(HttpServletRequest request);
	boolean isLogged(HttpServletRequest request);
}
