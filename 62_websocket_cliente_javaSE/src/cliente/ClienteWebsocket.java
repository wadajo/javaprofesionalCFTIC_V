package cliente;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class ClienteWebsocket {
	Session sesion;
	public ClienteWebsocket (String url) {
		// instrucciones para realizar la conexión con el Websocket del servidor
		try {
			URI endPoint=new URI(url);
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, endPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@OnOpen
	public void alAbrirSesion(Session sesion) {
		this.sesion=sesion;
	}
	
	// @OnClose podríamos hacer algo también
	
	@OnMessage
	public void alRecibirMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	// fuera de los métodos del ciclo de vida quiero implementar más funcionalidades
	public void enviarMensaje(String mensaje) {
		try {
			sesion.getBasicRemote().sendText(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void cerrarConexion() {
		try {
			sesion.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
