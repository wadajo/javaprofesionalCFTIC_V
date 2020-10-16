package principal;

import cliente.ClienteWebsocket;

public class Prueba {
	public static void main(String[] args) {
		ClienteWebsocket cliente=new ClienteWebsocket("ws://localhost:8080/56_ejemplo_websocket_servidor/saludo");
		cliente.enviarMensaje("\nHola, servidor, soy el cliente.");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cliente.cerrarConexion();
	}
}
