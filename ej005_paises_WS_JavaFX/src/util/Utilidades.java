package util;

import java.util.stream.Stream;

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
