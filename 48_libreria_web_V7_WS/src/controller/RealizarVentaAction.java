package controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;
import service.ClienteService;
import service.LibroService;
import service.VentasService;

@WebServlet("/RealizarVenta")
public class RealizarVentaAction extends HttpServlet {
	@Inject
	LibroService serviceLibro;
	@Inject
	ClienteService serviceCliente;
	@Inject
	VentasService serviceVentas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		List<Libro> miCarrito=(List<Libro>)session.getAttribute("carrito");
		
		request.setAttribute("venta", true);
		try {
			serviceVentas.realizarVenta(miCarrito, (Cliente)session.getAttribute("logeado"));			
		// acá pasaría si no existen los filtros en la aplicación
		} catch (SinLibrosException e) {			
			request.setAttribute("venta", false);
			request.setAttribute("mensajeError", e.getMessage());
			
			e.printStackTrace();
		}		
		
		miCarrito.clear();
		request.getRequestDispatcher("CargarTemas").include(request, response);
	}

}
