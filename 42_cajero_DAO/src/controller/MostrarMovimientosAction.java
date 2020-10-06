package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cuenta;
import service.CajeroService;
import service.CajeroServiceFactory;

@WebServlet("/MostrarMovimientos")
public class MostrarMovimientosAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		CajeroService service=CajeroServiceFactory.getCajeroService();
		
		request.setAttribute("movimientos", service.obtenerMovimientos(((Cuenta)session.getAttribute("logeada")).getId()));
	}

}
