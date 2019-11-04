package com.perscholas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({ "/HomeServlet", "/HomeServlet/*" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String action = null;
		if (pathInfo == null || pathInfo.equals("/")){
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}


		try {
			switch(action){
				case "/HomeServlet":
					System.out.println("Normal: "+action);
					showWelcome(request, response);
					break;
				case "/HomeServlet/securePage":
					System.out.println("Secure: "+action);
					showSecurePage(request, response);
					break;
				default:
					System.out.println("Default");
					showWelcome(request, response);
					break;
				}
		}
		catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showWelcome(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
	}
	
	private void showSecurePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/SecurePage.jsp").forward(request, response);
	}

}
