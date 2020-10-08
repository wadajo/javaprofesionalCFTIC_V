package controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.InfoPaisesService;

@WebServlet("/GenerarPaises")
public class GenerarPaisesAction extends HttpServlet {
	@Inject
	InfoPaisesService service;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<String> todoslospaises=service.recuperarPaises().keySet().stream()
									.sorted()
									.collect(Collectors.toList());
		request.getServletContext().setAttribute("listapaises", todoslospaises);
	}

}
