package service;

import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Pais;
import util.Utilidades;

@RequestScoped
@Named("infoPaisesService")
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
