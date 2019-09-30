package com.platform.simpleloginapp.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.platform.simpleloginapp.dao.SimpleLoginDAO;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleLoginDAO loginDAO = new SimpleLoginDAO();
		String user = request.getParameter("userName");
		String password = request.getParameter("password");
		HashMap<String, String> validUsers = null;
		
		try {
			validUsers = loginDAO.validUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (validUsers.containsKey(user)){
			if (password.equals(validUsers.get(user))) {
				response.sendRedirect("welcome.html");
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("alert('Password is incorrect');");
				   
			}
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("alert('User dies not exisit!');");
			   
		}
		
		doGet(request, response);
	}

}
