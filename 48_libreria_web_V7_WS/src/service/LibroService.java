package service;

import java.util.List;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;

public interface LibroService {
	List<Libro> mostrarTodosLosLibros();
	
	List<Libro> mostrarLibrosPorTema(String tema);
	
	Libro mostrarLibroPorIsbn(int isbn);
	
}
