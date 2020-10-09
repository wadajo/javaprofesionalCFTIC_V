package service;

import java.util.List;

import exceptions.SinLibrosException;
import model.Cliente;
import model.Libro;

public interface VentasService {
	boolean realizarVenta(List<Libro> aVender, Cliente comprador) throws SinLibrosException;
}
