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
import service.LibroService;
import service.ManejoBBDDFactory;

@WebServlet("/Agregar")
public class AgregarAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		List<Libro> miCarrito=(List<Libro>)session.getAttribute("carrito");
		Libro elegido=new Libro(Integer.parseInt(request.getParameter("isbn")),
								request.getParameter("titulo"),
								request.getParameter("autor"),
								Integer.parseInt(request.getParameter("precio")),
								Integer.parseInt(request.getParameter("paginas")),
								request.getParameter("tema"));
		miCarrito.add(elegido);
		// el carrito es automáticamente actualizado porque es un objeto en sesión
		request.getRequestDispatcher("LibrosPorTema").include(request, response);		
	}

}
