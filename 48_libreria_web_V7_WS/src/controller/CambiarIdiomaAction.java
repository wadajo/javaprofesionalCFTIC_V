package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CambiarIdioma")
public class CambiarIdiomaAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idioma=request.getParameter("idioma");
		HttpSession session=request.getSession();
		session.setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", idioma);
	}

}
