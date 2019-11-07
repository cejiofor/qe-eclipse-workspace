package com.perscholas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* This servlet is set to respond to requests with the URL pattern "/HomeServlet or 
 * "/HomeServlet followed by a slash and zero or more characters. */
@WebServlet({"/HomeControllerServlet", "/HomeControllerServlet/*"})
public class HomeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* The action string will be assigned the URL route and determine which 
		 * servlet method gets called by using a switch block. */
		String action = null;
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		
		/* If there are no characters after the servlet path (pathInfo will be 
		 * null) or if the servlet path is followed by a single "/" then the action 
		 * string will be assigned only the servlet path. If there is a slash 
		 * followed by any characters, then the action string will be assigned the 
		 * servlet path plus the additional path information. */
		if (pathInfo == null || pathInfo.equals("/")) {
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}
		// Verify the action string by printing to the console
		System.out.println(action);
		
		try
		{
			switch(action) {
				case "/HomeControllerServlet":
					showWelcome(request, response);
					break;
				case "/HomeControllerServlet/showProfile":
					showProfile(request, response);
					break;
				case "/HomeControllerServlet/showAboutUs":
					showAboutUs(request, response);
					break;
				default:
					showWelcome(request, response);
			}
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showWelcome(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/WelcomePage.jsp");
		rd.forward(request, response);
	}
	private void showProfile(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ProfilePage.jsp");
		rd.forward(request, response);
	}
	private void showAboutUs(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/AboutUsPage.jsp");
		rd.forward(request, response);
	}
}