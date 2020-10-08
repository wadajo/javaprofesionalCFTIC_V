package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.Libro;
import service.LibrosService;
import util.Utilidades;

@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	@Inject
	LibrosService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		List<Libro> librosAMostrar=service.devolverLibros();
		JSONArray array=new JSONArray();
		// encontrar otra manera, sin el foreach, es desprolijo
		librosAMostrar.forEach(unLibro->array.add(Utilidades.convertirLibroAJson(unLibro)));
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		out.print(array);
		// entrega el JSON, porque le especifiqué el tipo MIME
	}

}
