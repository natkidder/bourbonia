package com.bezkoder.spring.jpa.security;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
@Order(1) // order of execution for the same component (the lower the number, the higher the priority)
public class TransactionFilter implements Filter {
	
	private static final Logger LOG = Logger.getLogger(TransactionFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(
          "Starting a transaction for req : {}");
 
        chain.doFilter(request, response);
        LOG.info(
          "Committing a transaction for req : {}");
    }

}
