package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.business.LoginBusiness;
import br.edu.ifsp.dsw1.business.LoginBusinessImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
	private static LoginBusiness loginBusiness = new LoginBusinessImp();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		
		if ("login".equals(action)) {
			return login(request, response);
		}
		
		return "/index.jsp";
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (loginBusiness.validateLogin(username, password)) {
			loginBusiness.createSession(request);
			return "/home.jsp";
		}
		
		return "/index.jsp";
	}
}
