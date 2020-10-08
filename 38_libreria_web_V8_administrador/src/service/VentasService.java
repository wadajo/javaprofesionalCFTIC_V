package service;

import java.util.List;

import model.Venta;

public interface VentasService {
	List<Venta> devolverVentas();
	List<Venta> devolverVentasPorPagina(int paginaResultados);
	int paginasVentas();
}
