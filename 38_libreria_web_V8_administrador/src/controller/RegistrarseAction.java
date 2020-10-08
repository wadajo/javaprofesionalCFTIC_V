package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;
import service.ManejoBBDDFactory;

@WebServlet("/Registrarse")
public class RegistrarseAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteService service=ManejoBBDDFactory.getClienteService();
		service.altaCliente(request.getParameter("user"), 
							request.getParameter("pass"),
							request.getParameter("email"), 
							Integer.parseInt(request.getParameter("telefono")));		
	}

}
