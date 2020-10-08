package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option")==null?"doInicio":request.getParameter("option");
		switch(option) {
		case "doInicio":
			request.getRequestDispatcher("GenerarPaises").include(request, response);
			break;
		case "doDetallesPais":
			request.getRequestDispatcher("MostrarUnPais").include(request, response);
			break;		
		}
		request.getRequestDispatcher("infopaises.jsp").forward(request, response);
	}

}
