package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Venta {
	private Cliente cliente;
	private Timestamp fechaVenta;
	private Libro libro;
	public Venta() {		
	}
	public Venta(Cliente cliente, Timestamp fechaVenta, Libro libro) {
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
		this.libro = libro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Timestamp getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Timestamp fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
}
