package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.Libro;
import service.ClienteService;
import service.LibroService;
import service.ManejoBBDDFactory;

@WebServlet("/RealizarVenta")
public class RealizarVentaAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		ClienteService serviceCliente=ManejoBBDDFactory.getClienteService();
		LibroService serviceLibro=ManejoBBDDFactory.getLibroService();
		
		List<Libro> miCarrito=(List<Libro>)session.getAttribute("carrito");
		
			for (Libro libroAVender : miCarrito) {
				int idAVender=libroAVender.getIsbn();
				Cliente logeado=(Cliente)session.getAttribute("logeado");
				int idCliente=serviceCliente.devolverIdCliente(logeado);
				// es más eficiente pasarle una vez la lista al método, y el for allí
				serviceLibro.realizarVenta(idAVender, idCliente);
			}
		request.setAttribute("venta", "ok");
		session.setAttribute("carrito", new ArrayList<Libro>());
		request.getRequestDispatcher("CargarTemas").include(request, response);
	}

}
