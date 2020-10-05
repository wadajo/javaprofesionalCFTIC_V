package service;

import java.util.List;

import model.Cliente;
import model.Libro;

public interface ClienteService {
	
	Cliente autenticarCliente (String user, String pwd);
	
	Cliente altaCliente (String user, String pwd, String email, int telefono);

	Integer devolverIdCliente (Cliente deseado);
}
