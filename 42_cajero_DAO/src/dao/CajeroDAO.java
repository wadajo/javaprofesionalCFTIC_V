package dao;

import java.util.List;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface CajeroDAO {
	
	void insertarMovimiento(Movimiento nuevo);
	
	void actualizarSaldoCuenta(int numeroCuenta, double saldoNuevo);
	
	Cuenta recuperarCuenta(int numeroCuenta);
	
	List<Movimiento> recuperarMovimientos(int numeroCuenta);
	
	void insertarCliente(Cliente nuevo);
}
