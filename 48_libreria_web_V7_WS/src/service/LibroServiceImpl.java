package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.LibrosDAO;
import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;

@RequestScoped
@Named("libroService")
public class LibroServiceImpl implements LibroService {
	@Inject
	@Named("librosdaows")
	LibrosDAO librosDao;
	@Override
	public List<Libro> mostrarTodosLosLibros() {		
		return librosDao.recuperarTodosLosLibros();
	}

	@Override
	public List<Libro> mostrarLibrosPorTema(String tema) {
		return librosDao.recuperarLibrosPorTema(tema);
	}
	
	@Override
	public Libro mostrarLibroPorIsbn(int isbn) {
		return librosDao.recuperarLibroPorIsbn(isbn);
	}

}
