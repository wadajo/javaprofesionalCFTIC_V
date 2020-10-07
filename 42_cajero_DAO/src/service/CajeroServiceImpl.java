package service;

import java.time.LocalDateTime;
import java.util.List;

import dao.CajeroDAO;
import dao.CajeroDaoFactory;
import model.Cuenta;
import model.Movimiento;

class CajeroServiceImpl implements CajeroService {
	private CajeroDAO gestionDao=CajeroDaoFactory.getCajeroDao();
	
	// si no hay cuenta, podríamos arrojar excepciones personalizadas al Servlet
	@Override
	public Cuenta recuperarCuenta(int nroCuenta) {
		return gestionDao.recuperarCuenta(nroCuenta);
	}
	
	@Override
	public void ingresar(int cuenta, int dinero) {
		Cuenta actual=gestionDao.recuperarCuenta(cuenta);		
		if(null!=actual) {
			gestionDao.actualizarSaldoCuenta(cuenta, actual.getSaldo()+dinero);
			gestionDao.insertarMovimiento(new Movimiento(cuenta,LocalDateTime.now(),dinero,"ingreso"));
		}
	}

	@Override
	public void retirar(int cuenta, int dinero) {
		Cuenta actual=gestionDao.recuperarCuenta(cuenta);
		if (null!=actual&&actual.getSaldo()>dinero) {
		gestionDao.actualizarSaldoCuenta(cuenta, actual.getSaldo()-dinero);
		gestionDao.insertarMovimiento(new Movimiento(cuenta,LocalDateTime.now(),dinero,"extracción"));
		}
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int cuenta) {
		return gestionDao.recuperarMovimientos(cuenta);
	}

	@Override
	public void transferir(int origen, int destino, double dinero) {
		Cuenta inicio=gestionDao.recuperarCuenta(origen);
		Cuenta fin=gestionDao.recuperarCuenta(destino);
		if(null!=inicio&&null!=fin) {
			gestionDao.actualizarSaldoCuenta(origen, inicio.getSaldo()-dinero);
			gestionDao.insertarMovimiento(new Movimiento(origen,LocalDateTime.now(),dinero,"transferencia-extracción"));
			gestionDao.actualizarSaldoCuenta(destino, fin.getSaldo()+dinero);
			gestionDao.insertarMovimiento(new Movimiento(destino,LocalDateTime.now(),dinero,"transferencia-ingreso"));
		}
	}

	@Override
	public double obtenerSaldo(int cuenta) {
		if(null!=recuperarCuenta(cuenta))
			return gestionDao.recuperarCuenta(cuenta).getSaldo();
		else return 0;
	}

	

}
