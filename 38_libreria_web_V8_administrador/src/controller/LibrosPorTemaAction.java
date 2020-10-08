package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import service.LibroService;
import service.ManejoBBDDFactory;

@WebServlet("/LibrosPorTema")
public class LibrosPorTemaAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		LibroService service = ManejoBBDDFactory.getLibroService();
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
