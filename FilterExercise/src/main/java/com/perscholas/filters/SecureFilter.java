package com.perscholas.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class SecureFilter
 */
@WebFilter("/HomeServlet/securePage")
public class SecureFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecureFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		String key = req.getParameter("key");
		if (key != null && key.equals("qwerty")) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			response.getWriter().append("No valid key detected");
			String welcomeLink = "<a href=\"${pageContext.request.contextPath}/HomeServlet\">Welcome Page</a>";
			response.getWriter().append(welcomeLink);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
