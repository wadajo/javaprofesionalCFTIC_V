package controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.InfoPaisesService;

@WebServlet("/MostrarUnPais")
public class MostrarPaisAction extends HttpServlet {
	@Inject
	InfoPaisesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Pais elegido=service.devolverPais(request.getParameter("nombrepais"));
		request.setAttribute("paiselegido", elegido);
	}

}
