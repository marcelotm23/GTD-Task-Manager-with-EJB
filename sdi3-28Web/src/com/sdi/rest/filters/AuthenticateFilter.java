package com.sdi.rest.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import com.sdi.business.UserService;
import com.sdi.infrastructure.Factories;
import com.sdi.model.User;
import com.sdi.model.types.UserStatus;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, 
urlPatterns = { "/rest/LoginRs/*","/rest/ServiceRs/*"})
public class AuthenticateFilter implements Filter {

	private UserService userService = Factories.services.getUserService();

	/**
	 * Default constructor.
	 */
	public AuthenticateFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Si no es petición HTTP nada que hacer
		if (!(request instanceof HttpServletRequest)) {

			chain.doFilter(request, response);

			return;
		}
		// En el resto de casos se verifica que se haya hecho login previamente
		HttpServletRequest req = (HttpServletRequest) request;

		String cabecera = (String) req.getHeader("Authorization");
		if (cabecera != null) {

			String[] sinEspacio = cabecera.split(" ");
			String decodicado=new String(
					DatatypeConverter.parseBase64Binary(sinEspacio[1]));
			String[] datos = decodicado.split(":");
			String user = datos[0];
			String password = datos[1];
			User usr = userService.findLoggableUser(user, password);
		
			if (usr != null && usr.getStatus().equals(UserStatus.ENABLED)) {
				if(usr.getIsAdmin()){
					throw new ServletException("Solo los usuarios estandares pueden"
							+ " emplear este cliente.");
				}
				chain.doFilter(request, response);
			} else {
				return;
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
