package com.perscholas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginToServlet")
public class LoginToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("LoginForm.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userName = request.getParameter("userName");
//		String userPassword = request.getParameter("userPassword");
//		
//		if (userName.equals("testUser") && userPassword.equals("testPassword")) {
//			request.setAttribute("userName", userName);
//			request.getRequestDispatcher("Birthday.jsp")
//			.forward(request, response);
//		} else {
//			request.setAttribute("error", "Invalid Login");
//			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
//		}
	}
}
