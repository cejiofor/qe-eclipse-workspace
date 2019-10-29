package com.perscholas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		try
		{
			switch(action) {
			case "/firstCookiePage":
				cookiePage(request, response);
				break;
			case "/secondCookiePage":
				showSecondPage(request, response);
				break;
			default:
				cookiePage(request, response);
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void cookiePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* Cookies are set in this method and will be sent back to the browser
		 * in the response object and stored in the browser. The browser matches 
		 * the cookies present with the site URL. If a match is found, that 
		 * cookie is returned with the request.*/
		Cookie cookie1 = new Cookie("currentUser", "John");
		Cookie cookie2 = new Cookie("userLocation", "Dallas");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/CookiePage.jsp");
		rd.forward(request, response);
	}
	
	private void showSecondPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/SecondCookiePage.jsp");
		rd.forward(request, response);
	}

}
