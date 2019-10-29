package com.perscholas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenFieldsServlet
 */
@WebServlet("/HiddenFieldsServlet")
public class HiddenFieldsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		User user = new User(1, "John", "john@doe.com");
		request.setAttribute("currentUser", user);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/HiddenFields.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* The following parameters were provided from a form in the JSP 
		 * HiddenFields.jsp. The parameters "userId" and "email" were from 
		 * hidden fields*/
		User user = new User(Integer.parseInt(request.getParameter("userId")),
							request.getParameter("name"),
							request.getParameter("email"));
		// The data received will be displayed in the browser
		response.getWriter().append("User ID: " + user.getUserId()
							+ "\nName: " + user.getName()
							+ "\nEmail: " + user.getEmail() + "\n");
	}

}
