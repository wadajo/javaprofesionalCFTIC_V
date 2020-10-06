package model;

import java.util.List;

public class Cuenta {
	private int id;
	private List<Cliente> titulares;
	private int saldo=0;
	private String tipoCuenta;
	
	public Cuenta(int id, Cliente titular, String tipoCuenta) {
		this.id = id;
		this.titulares.add(titular);
		this.tipoCuenta = tipoCuenta;
	}
	public Cuenta(int id, List<Cliente> titulares, int saldo, String tipoCuenta) {
		this.id = id;
		this.titulares = titulares;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}	
	public Cuenta(int id, List<Cliente> titulares, String tipoCuenta) {
		this.id = id;
		this.titulares = titulares;
		this.tipoCuenta = tipoCuenta;
	}
	public Cuenta () {		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Cliente> getTitulares() {
		return titulares;
	}
	public void setTitulares(List<Cliente> titulares) {
		this.titulares = titulares;
	}
	public Cliente getT() {
		return titulares.get(0);
	}
	public void setT(Cliente t) {
		titulares.add(t);
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
}
