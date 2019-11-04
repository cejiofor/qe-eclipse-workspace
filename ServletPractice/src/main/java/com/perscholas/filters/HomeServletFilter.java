package com.perscholas.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/showPageTwo")
public class HomeServletFilter implements Filter {
	private String greeting;

        @Override
	public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("HomeServletFilter initialized.");
    	greeting = "Greetings from the servlet filter!";
	}

        @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		request.setAttribute("filterGreeting", greeting);
		chain.doFilter(request, response);
	}

        @Override
	public void destroy() {
    	System.out.println("HomeServletFilter taken out of service.");
	}
}
