package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ManejoBBDDFactory;
import service.VentasService;

@WebServlet("/VerVentas")
public class VentasAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		VentasService service=ManejoBBDDFactory.getVentasService();
		
		// tomamos del JSP la página a mostrar, o bien mostramos la 1ra
		int paginaAConsultar=request.getParameter("pagina")!=null?Integer.parseInt(request.getParameter("pagina")):1;
		request.setAttribute("ventas", service.devolverVentasPorPagina(paginaAConsultar));
		request.setAttribute("totalpaginas", service.paginasVentas());
	}

}
