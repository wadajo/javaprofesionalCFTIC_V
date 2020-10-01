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

@WebServlet("/Nuevo")
public class NuevoProductoServlet extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos;
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		RequestDispatcher pasar;
		
		if (null!=session.getAttribute("carrito")) {
			productos=(List<Producto>)session.getAttribute("carrito");
		} else {
			productos=new ArrayList<>();
			session.setAttribute("carrito", productos);
		}		
		productos.add(new Producto(
				request.getParameter("nombre"), 
				Integer.parseInt(request.getParameter("precio")), 
				request.getParameter("categoria")));		
		pasar=request.getRequestDispatcher("inicio.html");
		pasar.forward(request, response);
	}

}
