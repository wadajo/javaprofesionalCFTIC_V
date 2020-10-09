package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import service.ClienteService;
import service.LibroService;

@WebServlet("/Login")
public class LoginAction extends HttpServlet {
	@Inject
	ClienteService serviceCliente;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");				
		
		Cliente nuevo=serviceCliente.autenticarCliente(request.getParameter("user"),
												request.getParameter("pass"));
		if (nuevo!=null) {
			request.getSession().setAttribute("logeado", nuevo);			
			request.getRequestDispatcher("CargarTemas").include(request, response);
			request.setAttribute("resultado", true);			
		} else
			request.setAttribute("resultado", false);			
	}

}
