package com.perscholas.request_attribute;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.jsp_actions.Student;

@WebServlet("/ReqAttributeServlet")
public class ReqAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* This first example involves assigning a String object as a request 
		 * attribute. The key for this attribute will be "color". */
		request.setAttribute("color", "red");
		/* The second example involves a list of String objects ("colors") that will 
		 * be assigned as a request attribute. In this case the key and value are 
		 * the named identically to avoid confusion when retrieving the list 
		 * in the JSP. */
		List<String> colors = Arrays.asList("red", "green", "blue");
		request.setAttribute("colors", colors);
		/* The third example involves assigning an instance of the Student 
		 * class as a request attribute (Create a Student class with the 
		 * attributes/fields "studentId" and "name" to run this example). The 
		 * key is the string "student1" and the value is the object "student1". 
		 * Once again the key and value have been named identically to avoid 
		 * confusion. Naming them identically is not required. However, keys  
		 * must be strings and values must be objects. */
		Student student1 = new Student(1, "John");
		request.setAttribute("student1", student1);
		rd = request.getRequestDispatcher("/WEB-INF/views/ReqAttribute.jsp");
		rd.forward(request, response);
	}
}