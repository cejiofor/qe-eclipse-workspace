package com.perscholas.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.dao.BookDAO;
import com.perscholas.dao.MemberDAO;
import com.perscholas.models.Book;
import com.perscholas.models.Member;

@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }
    
    /*
     * Create an application that will:
		allow a member to register and log in to the application and display embedded red error messages if login and/or registration are invalid
		
		allow a member to create a book listing (i.e, a book)
		allow a member to check out a book
		allow the creator of a book listing to delete it
		
		display a welcome page for the club and use HttpSession to provide a personal greeting to the logged in member
		
		display a page with a list of all books (use the JSTL forEach method to iterate through the list; there should be a link to check out a book if available or return a book if the user has checked it out)
		
		Create a navigation HTML file for the pages that require login and use the include directive to display the navigation links on these pages (it should include a logout link)
     * */

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
				case "/HomeServlet/showRegistrationPage":
					showRegistration(request, response);
					break;
				case "/HomeServlet/registerMember":
					registerMember(request, response);
					break;				
				case "/HomeServlet/showBooksPage":
					showBooks(request, response);
					break;				
				case "/HomeServlet/createBook":
					createBook(request, response);
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
	
	private void loginMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
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
			request.setAttribute("errorMessage", "Invalid Login - user does not exist");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
		}
		
	}
	
	private void registerMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");	
		String password = request.getParameter("password");	
		String favoriteGenre = request.getParameter("favoriteGenre");	
		
		System.out.println(name + ", "+ email + ", "+ password+ ", "+ favoriteGenre);

		MemberDAO mdao = new MemberDAO();
		Member m = new Member(name, email, password, favoriteGenre);
		Integer i = mdao.createMember(m);
		m.setMemberId(i);
		System.out.println(i);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}

	private void createBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String synopsis = request.getParameter("synopsis");
		String author = request.getParameter("author");
		String pubDateString = request.getParameter("pubDate");
		LocalDate pubDate = LocalDate.parse(pubDateString);
		Member currentMember = (Member) session.getAttribute("currentMember");
				
		Book book = new Book(title, synopsis, author, pubDate, currentMember.getMemberId());
		
		BookDAO bdao = new BookDAO();
		bdao.createBook(book);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showEventsPage");
		rd.forward(request, response);
	}
	
	private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}
	
	private void showRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/RegistrationPage.jsp");
		rd.forward(request, response);
	}
	
	private void showBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/BooksPage.jsp");
		rd.forward(request, response);
	}

}
