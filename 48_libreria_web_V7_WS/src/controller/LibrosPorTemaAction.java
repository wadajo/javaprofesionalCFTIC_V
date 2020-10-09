package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibroService;

@WebServlet("/LibrosPorTema")
public class LibrosPorTemaAction extends HttpServlet {
	@Inject
	LibroService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		List<Libro> librosPorTema;
		String temaPorParam=request.getParameter("temabuscado");
		if(temaPorParam.equals("todos"))
			librosPorTema=service.mostrarTodosLosLibros();			
		else
			librosPorTema=service.mostrarLibrosPorTema(temaPorParam);
		request.setAttribute("tema", temaPorParam);
		request.setAttribute("librosportema", librosPorTema);
		if (!librosPorTema.isEmpty())
			request.setAttribute("resultado", true);
		else
			request.setAttribute("resultado", false);
	}

}
