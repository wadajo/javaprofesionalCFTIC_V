package dao;

import java.util.List;

import model.Libro;

public interface LibrosDAO {
	List<Libro> recuperarTodosLosLibros();	
	List<Libro> recuperarLibrosPorTema(String tema);
	Libro recuperarLibroPorIsbn(int isbn);
}
