package service;

import java.util.Map;

import model.Pais;

public interface InfoPaisesService {
	Pais devolverPais(String nombre);
	Map<String,Pais> recuperarPaises();
}
