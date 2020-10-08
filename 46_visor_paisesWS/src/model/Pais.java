package model;

public class Pais {
	private String nombre;
	private String region;
	private Long habitantes;
	private String capital;
	private String bandera;	
	
	
	public Pais(String nombre, String region, Long habitantes, String capital, String bandera) {
		this.nombre = nombre;
		this.region = region;
		this.habitantes = habitantes;
		this.capital = capital;
		this.bandera = bandera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(Long habitantes) {
		this.habitantes = habitantes;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getBandera() {
		return bandera;
	}
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}	
}
