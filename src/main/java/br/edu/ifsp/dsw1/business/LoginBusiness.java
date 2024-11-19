package br.edu.ifsp.dsw1.business;

import br.edu.ifsp.dsw1.exception.InvalidLoginException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public interface LoginBusiness {
	HttpSession createSessionByLogin(String username, String password, HttpServletRequest request) throws InvalidLoginException;
	HttpSession createSession(HttpServletRequest request);
	void terminateSession(HttpServletRequest request);
	boolean isLogged(HttpServletRequest request);
}
