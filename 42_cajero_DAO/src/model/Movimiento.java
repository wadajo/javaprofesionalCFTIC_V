package model;

import java.time.LocalDateTime;

public class Movimiento {
	private int cuenta;
	private LocalDateTime fecha;
	private double dinero;
	private String operacion;
	
	public Movimiento(int cuenta, LocalDateTime fecha, double dinero, String operacion) {
		this.cuenta = cuenta;
		this.fecha = fecha;
		this.dinero = dinero;
		this.operacion = operacion;
	}
	
	public int getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public double getDinero() {
		return dinero;
	}
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
}
