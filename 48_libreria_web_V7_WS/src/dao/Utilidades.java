package dao;

import org.json.simple.JSONObject;

import model.Libro;

public class Utilidades {
	public static Libro convertirJsonALibro(JSONObject ob) {
		return new Libro(
				// los datos enteros, la API JSONsimple los devuelve en Long
				((Long)ob.get("isbn")).intValue(),
				(String)ob.get("titulo"),
				(String)ob.get("autor"),
				(Double)ob.get("precio"),
				0,
				(String)ob.get("tematica"));
	}
}