package service;

public class ManejoBBDDFactory {
	public static ClienteService getClienteService () {
		return new ClienteServiceImpl();
	}
	public static LibroService getLibroService() {
		return new LibroServiceImpl();
	}
	public static VentasService getVentasService() {
		return new VentasServiceImpl();
	}
}
