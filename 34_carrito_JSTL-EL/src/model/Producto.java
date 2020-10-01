package model;

public class Producto {
	private String nombre;
	private int precio;
	private String categoria;	
	public Producto(String nombre, int precio, String categoria) {
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}
	public Producto() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}	
}
