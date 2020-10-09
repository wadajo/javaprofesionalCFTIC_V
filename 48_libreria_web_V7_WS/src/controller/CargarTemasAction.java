package controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TemasService;

@WebServlet("/CargarTemas")
public class CargarTemasAction extends HttpServlet {
	@Inject
	TemasService service;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	
		request.setAttribute("temas", service.mostrarTemas());
	}

}
