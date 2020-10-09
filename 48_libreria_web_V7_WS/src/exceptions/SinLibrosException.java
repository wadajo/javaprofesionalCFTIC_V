package exceptions;

public class SinLibrosException extends Exception {
	public SinLibrosException() {
		super("No hay libros en tu carrito para vender.");
	}
}
