package util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Pais;
import service.Datos;

public class Utilidades {	
	
	public static Stream<Pais> mapearAPaises() {
		return Datos.parser()
				.parallel()
				.map(p->new Pais((String)p.get("name"),
						(String)p.get("region"),
						(Long)p.get("population"),
						(String)p.get("capital"),
						(String)p.get("flag")));
	}
}
