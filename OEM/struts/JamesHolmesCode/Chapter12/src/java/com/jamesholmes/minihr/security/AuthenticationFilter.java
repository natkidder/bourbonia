package com.jamesholmes.minihr.security;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationFilter implements Filter
{
  public void init(FilterConfig filterConfig) throws ServletException {
  }
   
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain) 
                 throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
    
    HttpSession session = req.getSession(); // get the session or create it
    User user = (User) session.getAttribute("user");
    if (user == null) {
    	// redirect to the login page 
    	res.sendRedirect("/MiniHR19/index.jsp");
    }
    else {
			chain.doFilter(request, response);
    }
  }

	public void destroy() {
	}
}