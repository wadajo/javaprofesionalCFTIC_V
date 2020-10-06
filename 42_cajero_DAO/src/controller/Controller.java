package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String option=request.getParameter("option");
		String url="login.html";
		switch(option) {
		case "toLogin":			
			url="login.html";
			break;
		case "doLogin":
			request.getRequestDispatcher("Login").include(request, response);
			url=(Boolean)request.getAttribute("resultado")==true?"menu.html":"login_error.html";			
			break;
		case "toIngresar":			
			url="ingresar.jsp";
			break;
		case "doIngresar":
			request.getRequestDispatcher("Ingresar").include(request, response);
			url="menu.html";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
