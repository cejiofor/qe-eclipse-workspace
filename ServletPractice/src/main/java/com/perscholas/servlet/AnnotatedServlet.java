package com.perscholas.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;

@WebServlet(urlPatterns = {"/AnnotatedServlet"}, initParams= {
		@WebInitParam(name="annotatedParam", 
				value="This is an annotated init param"),
		@WebInitParam(name="secondInitParam", 
				value="This is the second annotated init param")})

public class AnnotatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String firstInitParam;
    String secondInitParam;
    
    public AnnotatedServlet() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		firstInitParam = config.getInitParameter("annotatedParam");
		secondInitParam = config.getInitParameter("secondInitParam");
	}

    @Override
	public void destroy() {

	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append("\n" + firstInitParam)
		.append("\n" + secondInitParam);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
