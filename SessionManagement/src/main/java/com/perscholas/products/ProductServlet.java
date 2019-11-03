package com.perscholas.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Phone");
		product.setProductDescription("New xPhone 50");

		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/UpdatePage.jsp");
		rd.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getConteXxtPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int productID = Integer.parseInt(request.getParameter("productId"));
		String productID = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String description = request.getParameter("productDescription");
		
		System.out.printf("Product ID %s updated to:%nName: %s%nDescription: %s%n",productID, productName, description);
		doGet(request, response);
	}

}
