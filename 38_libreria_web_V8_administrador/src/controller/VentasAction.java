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
		
		request.setAttribute("ventas", service.devolverVentas());
	}

}
