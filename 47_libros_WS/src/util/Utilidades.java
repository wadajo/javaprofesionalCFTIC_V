package util;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Libro;

public class Utilidades {
	public static JSONObject convertirLibroAJson(Libro unLibro) {
		JSONObject objetoJson=new JSONObject();		
		objetoJson.put("titulo", unLibro.getTitulo());
		objetoJson.put("tematica", unLibro.getTema());
		objetoJson.put("autor", unLibro.getAutor());
		// quizás no interesa, no lo pongo | objetoJson.put("paginas", unLibro.getPaginas());
		objetoJson.put("precio", unLibro.getPrecio());
		return objetoJson;
	}
	public static JSONObject[] convertirListaLibrosAJsonObject(List<Libro> libros) {
		JSONObject[] arrayJson=new JSONObject[libros.size()];
		for (Libro unLibro : libros) {
			arrayJson[libros.indexOf(unLibro)]=(JSONObject) new JSONObject().put("titulo", unLibro.getTitulo());
		}
		return arrayJson;
	}
	public static JSONArray convertirListaLibrosAJsonArray(List<Libro> libros) {
		JSONArray arrayJson=new JSONArray();
		for (Libro unLibro : libros) {
			JSONObject unLibroEnJson=new JSONObject();		
			unLibroEnJson.put("titulo", unLibro.getTitulo());
			unLibroEnJson.put("tematica", unLibro.getTema());
			unLibroEnJson.put("autor", unLibro.getAutor());
			unLibroEnJson.put("precio", unLibro.getPrecio());
			arrayJson.add(unLibroEnJson);
		}
		return arrayJson;
	}
}
