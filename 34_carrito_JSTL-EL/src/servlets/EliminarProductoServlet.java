package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Producto;

@WebServlet("/Eliminar")
public class EliminarProductoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		RequestDispatcher pasar;
		if(session.getAttribute("carrito")!=null) {
			List<Producto> carrito=(List<Producto>)session.getAttribute("carrito");
		
			int aEliminar=Integer.parseInt(request.getParameter("indice"));
			carrito.remove(aEliminar);
			if (!carrito.isEmpty()) {
			pasar=request.getRequestDispatcher("carrito.jsp");
			pasar.forward(request, response);
			} else {
			pasar=request.getRequestDispatcher("vacio.html");
			pasar.forward(request, response);
		}
		
		}
	}

}
