package com.perscholas.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.dao.EventDAO;
import com.perscholas.dao.MemberDAO;
import com.perscholas.models.Event;
import com.perscholas.models.Member;

/**
 * Servlet implementation class HomeServlet
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String action = null;
		System.out.println(servletPath + " saklmdal "+pathInfo);
		if (pathInfo == null || pathInfo.equals("/")){
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}


		try {
			switch(action){
				case "/HomeServlet":
					showLogin(request, response);
					break;
				case "/HomeServlet/loginMember":
					loginMember(request, response);
					break;
				case "/HomeServlet/showRegistrationPahe":
					showRegistration(request, response);
					break;
				case "/HomeServlet/registerMember":
					registerMember(request, response);
					break;				
				case "/HomeServlet/showEventsPage":
					showEvents(request, response);
					break;				
				case "/HomeServlet/createEvent":
					createEvent(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
//		rd.forward(request, response);
		request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp").forward(request, response);
		
	}
	
	private void loginMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");		
		System.out.println(name + ": "+ password);
		
		HttpSession session = request.getSession();
		
		MemberDAO mdao = new MemberDAO();
		Member m = mdao.getMember(name);
		
		if (m!= null) {
			if (password.equals(m.getPassword())) {
				session.setAttribute("currentMember", m);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Welcome.jsp");
				rd.forward(request, response);
			} 
			else {
				request.setAttribute("errorMessage", "Invalid Login");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("errorMessage", "Invalid Login");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
		}
	}
	
	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/WelcomePage.jsp");
//		rd.forward(request, response);
		request.getRequestDispatcher("WEB-INF/views/WelcomePage.jsp").forward(request, response);
		
	}
	
	private void showRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/RegistrationPage.jsp");
		rd.forward(request, response);
		
	}
	
	private void registerMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");	
		String password = request.getParameter("password");	
		String favoriteLanguage = request.getParameter("favoriteLanguage");	
		
		System.out.println(name + ", "+ email + ", "+ password+ ", "+ favoriteLanguage);
		// TODO Auto-generated method stub
		
		MemberDAO mdao = new MemberDAO();
		Member m = new Member(name, email, password, favoriteLanguage);
		Integer i = mdao.createMember(m);
		m.setMemberId(i);
		System.out.println(i);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}
	
	private void showEvents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		EventDAO edao = new EventDAO();
		List<Event> eventList = edao.getEvents();
		request.setAttribute("eventList", eventList);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/EventsPage.jsp");
		rd.forward(request, response);
		
	}
	private void createEvent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String location = request.getParameter("location");
		String dateTimeString = request.getParameter("dateTime");
		LocalDateTime ldt = LocalDateTime.parse(dateTimeString);
		Member currentMember = (Member) session.getAttribute("currentMember");
				
		Event event = new Event(title, description, location, ldt, currentMember.getMemberId());
		
		EventDAO edao = new EventDAO();
		edao.createEvent(event);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showEventsPage");
		rd.forward(request, response);
		
	}

}
