package com.perscholas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static int getCount;
	
	@Override
	public void init() {
		getCount = 0;
		System.out.println("FirstServlet init method.");
	}
	
	@Override
	public void destroy() {
		System.out.println("FirstServlet destroy method.");
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		getCount++;
		System.out.println("FirstServlet doGet method. Count: " + getCount);
		response.getWriter().append("This is my first servlet!");
	}

}