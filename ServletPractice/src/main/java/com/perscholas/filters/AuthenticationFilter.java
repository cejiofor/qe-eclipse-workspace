package com.perscholas.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter( {"/showWelcomePage", "/showEditPage", "/events/showEvents"} )
public class AuthenticationFilter implements Filter {

        @Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if (session.getAttribute("currentUser") != null) {
			System.out.println(req.getServletPath() + ": Valid authentication.");
			chain.doFilter(request, response);
		} else {
			System.out.println(req.getServletPath() + ": Invalid authentication. User not logged in.");
			RequestDispatcher rd = request.getRequestDispatcher("/default");
    		        HttpServletResponse resp = (HttpServletResponse)response;
			rd.forward(req, resp);
		}
	}

}