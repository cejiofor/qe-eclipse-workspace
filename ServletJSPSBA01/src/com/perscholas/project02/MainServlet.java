package com.perscholas.project02;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.perscholas.project03.User;
import com.perscholas.project03.UserDAO;

/**
 * Servlet implementation class Project02Servlet
 */
@WebServlet({"/MainServlet", "/MainServlet/*"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String action = null;

		if (pathInfo == null || pathInfo.equals("/")){
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}
		System.out.println("get  "+action);
		try {
			switch(action){
//				case "/MainServlet":
//					showLogin(request, response);
//					break;
				case "/MainServlet/showLogin":
					showLogin(request, response);
					break;
				case "/MainServlet/loginForm":
					loginForm(request, response);
					break;
				case "/MainServlet/showProfile":
					showProfile(request, response);
					break;
				case "/MainServlet/showUpdate":
					showUpdate(request, response);
					break;
				case "/MainServlet/updateProfile":
					updateProfile(request, response);
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
    
	private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginForm.jsp");
		rd.forward(request, response);
	}
	
	private void showProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ProfilePage.jsp");
		rd.forward(request, response);
	}
	
	private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/UpdateProfile.jsp");
		rd.forward(request, response);
	}
	
	private void updateProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");	
		
		UserDAO udao = new UserDAO();
		User u = new User(userId, userName, password);
		
		Boolean updated = udao.updateUser(u);
		session.setAttribute("currentUser", u);
		System.out.println(updated);
		
		RequestDispatcher rd = request.getRequestDispatcher("/MainServlet/showProfile");
		rd.forward(request, response);
	}
	
	
	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName + ", "+password);
		
		System.out.println(userName + ": "+ password);
		
		HttpSession session = request.getSession();
		
		UserDAO udao = new UserDAO();
		User u = null;
		
		try {
			u = udao.findUserByName(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (u!= null) {
			if (password.equals(u.getPassword())) {
				session.setAttribute("currentUser", u);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
				rd.forward(request, response);
			} 
			else {
				request.setAttribute("errorMessage", "Invalid Login");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginForm.jsp");
				rd.forward(request, response);	
			}
		}
		else {
			request.setAttribute("errorMessage", "Invalid Login");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginForm.jsp");
			rd.forward(request, response);
		}    	
	}

}
