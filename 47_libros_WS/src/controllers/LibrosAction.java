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
		
		/*
		 * con Gson sería Gson gson=new Gson();
		 * String json=gson.toJson(librosAMostrar) y listo
		 * pero te manda todos los campos del JavaBean a menos que en ellos
		 * les pongas la keyword "transient" en atributos no deseados
		 */
		List<Libro> librosAMostrar=service.devolverLibros();
		JSONArray array=Utilidades.convertirListaLibrosAJsonArray(librosAMostrar);
		
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();		
		out.print(array);		
	}

}
