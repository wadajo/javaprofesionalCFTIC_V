package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cliente;

// acepta un array de direcciones desde las que pasará por el filtro
@WebFilter("/*")
public class FiltroControlUsuario implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=((HttpServletRequest)request).getSession();
		
		String path=((HttpServletRequest)request).getServletPath();		
		String param=((HttpServletRequest)request).getParameter("option");
		if (path.equals("/")||path.equals("/Controller")&&param.equals("doLogin")) {
			chain.doFilter(request, response);		
			return;
		}
		if (session.getAttribute("logeado")!=null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else
			((HttpServletRequest)request).getRequestDispatcher("login.html").forward(request, response);		
	}
}
