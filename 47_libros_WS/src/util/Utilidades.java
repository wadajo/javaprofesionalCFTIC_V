package util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Libro;

public class Utilidades {
	public static JSONObject convertirLibroAJson(Libro unLibro) {
		JSONObject objetoJson=new JSONObject();		
		objetoJson.put("isbn", unLibro.getIsbn());
		objetoJson.put("titulo", unLibro.getTitulo());
		objetoJson.put("tematica", unLibro.getTema());
		objetoJson.put("autor", unLibro.getAutor());		
		objetoJson.put("precio", unLibro.getPrecio());
		return objetoJson;
	}	
	public static JSONArray convertirListaLibrosAJsonArray(List<Libro> libros) {
		JSONArray arrayJson=new JSONArray();
		for (Libro unLibro : libros) {
			JSONObject unLibroEnJson=new JSONObject();		
			unLibroEnJson.put("isbn", unLibro.getIsbn());
			unLibroEnJson.put("titulo", unLibro.getTitulo());
			unLibroEnJson.put("tematica", unLibro.getTema());
			unLibroEnJson.put("autor", unLibro.getAutor());
			unLibroEnJson.put("precio", unLibro.getPrecio());
			arrayJson.add(unLibroEnJson);
		}
		return arrayJson;
	}
}
