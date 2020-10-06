package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.Cuenta;

/**
 * Application Lifecycle Listener implementation class CuentaListener
 *
 */
@WebListener
public class CuentaListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se)  { 
         se.getSession().setAttribute("logeada", new Cuenta());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
