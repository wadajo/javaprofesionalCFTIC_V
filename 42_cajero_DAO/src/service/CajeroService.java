package service;

import java.util.List;

import model.Cuenta;
import model.Movimiento;
import model.Cliente;

public interface CajeroService {

	Cuenta recuperarCuenta (int nroCuenta);
	
	void ingresar(int cuenta, int dinero);

	void retirar(int cuenta, int dinero);

	List<Movimiento> obtenerMovimientos(int cuenta);

	void transferir(int origen, int destino, double dinero);

	double obtenerSaldo(int cuenta);	

}