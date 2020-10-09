package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;

@WebServlet("/Registrarse")
public class RegistrarseAction extends HttpServlet {
	@Inject
	ClienteService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		service.altaCliente(request.getParameter("user"), 
							request.getParameter("pass"),
							request.getParameter("email"), 
							Integer.parseInt(request.getParameter("telefono")));		
	}

}
