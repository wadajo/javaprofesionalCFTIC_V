package service;

import java.util.Map;
import java.util.stream.Collectors;

import model.Pais;
import util.Utilidades;

public class InfoPaisesServiceImpl implements InfoPaisesService {
	@Override
	public Pais devolverPais(String nombre) {
		return Utilidades.mapearAPaises()		
			.filter(pais->pais.getNombre().equals(nombre))
			.findAny()
			.orElse(null);
	}
	@Override
	public Map<String, Pais> recuperarPaises() {
		return Utilidades.mapearAPaises()
				.collect(Collectors.toMap(pais->pais.getNombre(),pais->pais));
	}

}
