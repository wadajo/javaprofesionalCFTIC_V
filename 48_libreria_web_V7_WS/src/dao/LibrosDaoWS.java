package dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.json.simple.JSONObject;

import model.Libro;

@RequestScoped
@Named("librosdaows")
public class LibrosDaoWS implements LibrosDAO {

	@Override
	public List<Libro> recuperarTodosLosLibros() {
		Stream<JSONObject> stream=DatosRemotos.getJson();		
		return stream
				.collect(Collectors.mapping(obJson->Utilidades.convertirJsonALibro(obJson), Collectors.toList()));
	}

	@Override
	public List<Libro> recuperarLibrosPorTema(String tema) {
		Stream<JSONObject> stream=DatosRemotos.getJson();		
		return stream
				.map(obJson->Utilidades.convertirJsonALibro(obJson))
				.collect(Collectors.filtering(libro->libro.getTema().equalsIgnoreCase(tema), Collectors.toList()));
	}

	@Override
	public Libro recuperarLibroPorIsbn(int isbn) {
		Stream<JSONObject> stream=DatosRemotos.getJson();		
		return stream
				.map(obJson->Utilidades.convertirJsonALibro(obJson))
				.filter(libro->libro.getIsbn()==isbn)
				.findAny()
				.orElse(new Libro());
	}

}
