package util;

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
}
