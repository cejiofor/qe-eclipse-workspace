package com.perscholas.filters;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HoomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		try
		{
			switch (action) {
				case "/":
					showPageOne(request, response);
					break;
				case "/showPageTwo":
					showPageTwo(request, response);
					break;
				default:
				System.out.println("Default case.");
			}
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showPageOne(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		rd = request.getRequestDispatcher("WEB-INF/views/PageOne.jsp");
		rd.forward(request, response);
	}
	
	private void showPageTwo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		rd = request.getRequestDispatcher("WEB-INF/views/PageTwo.jsp");
		rd.forward(request, response);
	}

}
