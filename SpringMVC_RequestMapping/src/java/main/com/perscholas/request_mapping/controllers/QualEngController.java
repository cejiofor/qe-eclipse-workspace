package com.perscholas.request_mapping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qualEng")
public class QualEngController {
	private String course = "Quality Engineering & Assurance";
	private String displayPage = "PerScholasHome";
	
	//String return types
	@RequestMapping("/")
	public String defaultView(Model model) {
		model.addAttribute("heading", course);
		return displayPage;
	}
	
	//ModelAndView return types
	@RequestMapping("courseId")
	public ModelAndView showCourseId() {
		/* The ModelAndView constructor is overloaded to include a version that will
		 * accept a view name along with a Model key-value pair. This is demonstrated 
		 * in the following line of code. The second line simply adds another 
		 * key-value pair to the Model so after this method runs there will be two 
		 * key-value pairs in the Model object. */
		ModelAndView mav = new ModelAndView(displayPage, "heading", course);;
		mav.addObject("message", "2019-DAL-01");
		return mav;
	}
//	@RequestMapping("/courseId")
//	public String showCourseId(Model model) {
//		model.addAttribute("heading", course);
//		model.addAttribute("message", "2019-DAL-01");
//		return displayPage;
//	}
	
	//String return types
	@RequestMapping("/location")
	public String showLocation(Model model) {
		/* This method returns a String which represents a JSP. The method also 
		 * accepts a Model object that is injected by the Spring container. Key-value 
		 * pairs are added to the Model object using the "addAttribute()" method. */
		model.addAttribute("heading", course);
		model.addAttribute("message", "Dallas");
		return displayPage;
	}
	

}
