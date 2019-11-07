package com.perscholas.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.dao.HomeDAO;
import com.perscholas.dao.HomeQuotesDAO;
import com.perscholas.dao.QuoteDAO;
import com.perscholas.dao.UserDAO;
import com.perscholas.models.Home;
import com.perscholas.models.HomeQuote;
import com.perscholas.models.Quote;
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
				case "/HomeServlet/showRegistration":
					showRegistration(request, response);
					break;
				case "/HomeServlet/registerMember":
					registerMember(request, response);
					break;	
				case "/HomeServlet/newQuote":
					newQuote(request, response);
					break;	
				case "/HomeServlet/getQuote":
					getQuote(request, response);
					break;
				case "/HomeServlet/addQuote":
					addQuote(request, response);
					break;	
				case "/HomeServlet/showWelcome":
					showWelcome(request, response);
					break;
				case "/HomeServlet/retrieveQuotes":
					retrieveQuotes(request, response);
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
	
	private void showRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}
	
	private void registerMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String firstName = request.getParameter("firstName");		
		String lastName = request.getParameter("lastName");
		LocalDate userDOB = LocalDate.parse(request.getParameter("userDOB"));
		String userEmail = request.getParameter("userEmail");	
		String userPassword = request.getParameter("userPassword");
		UserDAO udao = new UserDAO();
		User u = new User(firstName, lastName, userEmail, userPassword, userDOB);
		Integer id = udao.createUser(u);
		u.setUserId(id);
		System.out.println(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Login.jsp");
		rd.forward(request, response);
	}

	private void getQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/GetQuote.jsp");
		rd.forward(request, response);
	}
	
	private void newQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		User currentUser = (User) session.getAttribute("currentUser");
		int userId = currentUser.getUserId();
		String address1 = request.getParameter("address1");		
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");	
		String state = request.getParameter("state");		
		int zip = Integer.parseInt(request.getParameter("zip"));
		int yearBuilt = Integer.parseInt(request.getParameter("yearBuilt"));
		double homeValue = Double.parseDouble(request.getParameter("homeValue"));
		
		HomeDAO hdao = new HomeDAO();
		Home h = new Home(userId, address1, address2, city, state, zip, yearBuilt, homeValue);

		Integer id = hdao.createHome(h);
		h.setHomeId(id);
		System.out.println(id);
		
		session.setAttribute("currentHome", h);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Quote.jsp");
		rd.forward(request, response);
	}
	
	private void addQuote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		User currentUser = (User) session.getAttribute("currentUser");
		Home currentHome = (Home) session.getAttribute("currentHome");
		
		int homeId = currentHome.getHomeId();
		Double yearlyPremium = (Double) session.getAttribute("premium");
		System.out.println(homeId);
		System.out.println(homeId + yearlyPremium);
		LocalDate startDate = LocalDate.now();
		LocalDate expiration = startDate.plusYears(10);
		Boolean active = true;
		
		QuoteDAO qdao = new QuoteDAO();
		Quote q = new Quote(homeId, yearlyPremium, startDate, expiration, active);
		Integer id = qdao.createQuote(q);
		q.setQuoteId(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ThankYou.jsp");
		rd.forward(request, response);
	}
	
	private void showWelcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
		rd.forward(request, response);
	}
	
	private void retrieveQuotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		QuoteDAO qdao = new QuoteDAO();
		List<Quote> quoteList = qdao.getQuotes();
		request.setAttribute("quoteList", quoteList);
		HomeQuotesDAO hqdao = new HomeQuotesDAO();
		Boolean update = hqdao.addHomeQuotes();
		List<HomeQuote> homeQuoteList = hqdao.getHomeQuotes();
		request.setAttribute("homeQuoteList", homeQuoteList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RetrieveQuotes.jsp");
		rd.forward(request, response);
	}
}
