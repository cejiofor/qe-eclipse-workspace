package com.perscholas.chaining;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet333
 */
@WebServlet("/Servlet333")
public class Servlet333 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet333() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	response.getWriter()
		.append("<body><p>Text from Servlet333 Curabitur arcu erat, accumsan "
				+ "id imperdiet et, porttitor at sem. Proin eget tortor risus. "
				+ "Curabitur aliquet quam id dui posuere blandit. Vivamus "
				+ "magna justo, lacinia eget consectetur sed, convallis at "
				+ "tellus. Curabitur arcu erat, accumsan id imperdiet et, "
				+ "porttitor at sem. Curabitur aliquet quam id dui posuere "
				+ "blandit. Nulla porttitor accumsan tincidunt. Mauris blandit "
				+ "aliquet elit, eget tincidunt nibh pulvinar a. Nulla "
				+ "porttitor accumsan tincidunt. Donec sollicitudin molestie "
				+ "malesuada.</p></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
