package com.jamesholmes.minihr.security;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts.Globals;
import org.apache.struts.action.*;

public class AuthorizationFilter implements Filter
{
  public void init(FilterConfig filterConfig) throws ServletException {
		String roles = filterConfig.getInitParameter("roles");
		if (roles == null || "".equals(roles)) {
		  roleNames = new String[0];
		}
		else {
			roles.trim();
			roleNames = roles.split("\\s*,\\s*");
		}
		onErrorUrl = filterConfig.getInitParameter("onError");
		if (onErrorUrl == null || "".equals(onErrorUrl)) {
			onErrorUrl = "/index.jsp";
		}
  }

	public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain) 
                 throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
    
    HttpSession session = req.getSession(); // get the session or create it
    User user = (User) session.getAttribute("user");
    ActionErrors errors = new ActionErrors();
    if (user == null) {
    	errors.add(ActionErrors.GLOBAL_ERROR, new ActionMessage( "error.authentication.required" ));
    }
    else {
    	boolean hasRole = false;
    	for (int i=0; i<roleNames.length; i++) {
    		if (user.hasRole(roleNames[i])) {
    			hasRole = true;
    			break;
    		}
    	}
    	if (!hasRole) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionMessage( "error.authorization.required" ));
    	}
		}

    if (errors.isEmpty()) {
			chain.doFilter(request, response);    	
    }
    else {    	
			req.setAttribute(Globals.ERROR_KEY, errors);
			req.getRequestDispatcher(onErrorUrl).forward(req, res);    	
    }
  }

	public void destroy() {
	}

	private String[] roleNames;
	private String onErrorUrl;
}