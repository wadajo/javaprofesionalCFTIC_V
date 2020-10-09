package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Libro;

@WebServlet("/Quitar")
public class QuitarAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		List<Libro> miCarrito=(List<Libro>)session.getAttribute("carrito");
		// comprobar por si ha caducado la sesión y devuelve carrito vacío
		if (!miCarrito.isEmpty())
			miCarrito.remove(Integer.parseInt(request.getParameter("posicion")));
		// el carrito es automáticamente actualizado porque es un objeto en sesión
		request.getRequestDispatcher("LibrosPorTema").include(request, response);
	}

}
