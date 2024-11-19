package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.business.LoginBusiness;
import br.edu.ifsp.dsw1.business.LoginBusinessImp;
import br.edu.ifsp.dsw1.exception.InvalidLoginException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
	private static LoginBusiness loginBusiness = new LoginBusinessImp();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = (String) request.getParameter("action");
			
			if ("login".equals(action)) {
				return login(request, response);
			}			
		}
		catch(Throwable t) {
			request.setAttribute("error", t.getMessage());
		}
		
		return "/index.jsp";
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws InvalidLoginException {		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			loginBusiness.createSessionByLogin(username, password, request);
			return "/home.jsp";
		}
		catch(Throwable t) {
			System.out.println("error login " + t);
			throw t;
		}
	}
}
