package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String option=request.getParameter("option");
		String url="login.html";
		switch(option) {
		case "doLogin":
			request.getRequestDispatcher("Login").include(request, response);
			url=(Boolean)request.getAttribute("resultado")==true?"buscarPorTema.jsp":"login_error.html";
			break;
		case "toLogin":
			url="login.html";
			break;
		case "toRegistro":
			url="registro.html";
			break;
		case "doRegistro":
			request.getRequestDispatcher("Registrarse").include(request, response);
			url="login.html";
			break;
		case "doLibrosPorTema":
			request.getRequestDispatcher("LibrosPorTema").include(request, response);
			url=(Boolean)request.getAttribute("resultado")==true?"librosPorTema.jsp":"librosportema_error.html";
			break;
		case "toLibrosPorTema":
			request.getRequestDispatcher("CargarTemas").include(request, response);
			url="buscarPorTema.jsp";
			break;
		case "doAgregar":
			request.getRequestDispatcher("Agregar").include(request, response);
			url="librosPorTema.jsp";
			break;
		case "doQuitar":
			request.getRequestDispatcher("Quitar").include(request, response);
			url="librosPorTema.jsp";
			break;
		case "doVender":
			request.getRequestDispatcher("RealizarVenta").include(request, response);
			url="buscarPorTema.jsp";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
