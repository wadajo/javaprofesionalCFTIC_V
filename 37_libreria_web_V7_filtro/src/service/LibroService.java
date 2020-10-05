package service;

import java.util.List;

import model.Libro;

public interface LibroService {
	List<Libro> mostrarTodosLosLibros();
	
	List<Libro> mostrarLibrosPorTema(String tema);
	
	List<String> mostrarTemas();
	
	boolean realizarVenta (int idAVender, int idCliente);
}
