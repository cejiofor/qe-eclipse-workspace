package com.perscholas.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.daos.UserDAO;
import com.perscholas.models.User;

/**
 * Servlet implementation class HomeServlet
 * 
  */
@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String action = null;
		
		
		/* If there are no characters after the servlet path (pathInfo will be 
		 * null) or if the servlet path is followed by a single "/" then the action 
		 * string will be assigned only the servlet path. If there is a slash 
		 * followed by any characters, then the action string will be assigned the 
		 * servlet path plus the additional path information. */
		if (pathInfo == null || pathInfo.equals("/")){
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}


		try {
			switch(action){
//				case "/HomeServlet/":
//					showLogin(request, response);
//					break;
				case "/HomeServlet/showLogin":
					showLogin(request, response);
					break;
				case "/HomeServlet/loginMember":
					loginMember(request, response);
					break;
				default:
					showLogin(request, response);
					break;
				}
		}
		catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		rd.forward(request, response);	
	}
	
	private void loginMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");		
		System.out.println(userEmail + ": "+ userPassword);
		
		HttpSession session = request.getSession();
		
		UserDAO udao = new UserDAO();
		User u = udao.getUser(userEmail);
		
		if (u!= null) {
			if (userPassword.equals(u.getUserPassword())) {
				session.setAttribute("currentUser", u);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
				rd.forward(request, response);
				
			} 
			else {
				request.setAttribute("errorMessage", "Invalid Login");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
				rd.forward(request, response);	
			}
		}
		else {
			request.setAttribute("errorMessage", "Invalid Login");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
			rd.forward(request, response);
		}
	}

}
