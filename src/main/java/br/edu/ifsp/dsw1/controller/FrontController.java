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

@WebServlet("/frontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DEFAULT_COMMAND_PATH = "br.edu.ifsp.dsw1.command.";
	
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
