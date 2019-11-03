package com.perscholas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginToServlet")
public class LoginToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Cookie userCookie = new Cookie("username", "null");
		Cookie passwordCookie = new Cookie("password", "null");
	    Cookie birthdayCookie = new Cookie("birthday", "null");
	    response.addCookie(userCookie);
		response.addCookie(passwordCookie);
		response.addCookie(birthdayCookie);
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		String birthday = request.getParameter("birthday");
		HttpSession session = request.getSession();
		
		// Handle User login code
		if (request.getParameter("login") != null) {
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			if (userName.equals(username) && userPassword.equals(password)) {
//				request.getRequestDispatcher("Birthday.jsp").forward(request, response);;
				response.sendRedirect("Birthday.jsp");
			} else {
				request.setAttribute("error","Login unsuccessful");
				request.getRequestDispatcher("LoginForm.jsp").forward(request, response);;
			}
		}
		
		//Handle User Registration code
		if(request.getParameter("register") != null) {
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		if (request.getParameter("sumbitregister") != null) {
			Cookie userCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);
		    Cookie birthdayCookie = new Cookie("birthday", birthday);
		    response.addCookie(userCookie);
			response.addCookie(passwordCookie);
			response.addCookie(birthdayCookie);
//			response.sendRedirect("LoginForm.jsp");
			request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		}
	}
}
