package com.perscholas.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet111
 */
@WebServlet("/Servlet111")
public class Servlet111 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet111() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		/* Create <style> tags to format the <a> tags in the <nav> bar*/
		response.getWriter()
		.append("<style>"
				+ "a { "
				+ "background-color: #aaccaa;"
				+ "color: #997799;"
				+ "padding: 5px 10px;"
				+ "margin: 5px;"
				+ "border: 2px solid #bbbbbb;"
				+ "border-radius: 3px;"
				+ "}"
				+ "</style>");
		// Include response from Servlet222 - header and nav bar
        RequestDispatcher rd = request.getRequestDispatcher("Servlet222");
		rd.include(request, response);
		// Include response from Servlet333 - body of the page
		rd = request.getRequestDispatcher("Servlet333");
		rd.include(request, response);	
		// Include response from Servlet444 - footer
		rd = request.getRequestDispatcher("Servlet444");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
