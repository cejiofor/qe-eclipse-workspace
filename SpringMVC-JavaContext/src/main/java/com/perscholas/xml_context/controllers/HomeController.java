package com.perscholas.xml_context.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.perscholas.xml_context.beans.ApplicationService;
import com.perscholas.xml_context.beans.CourseRepository;
import com.perscholas.xml_context.beans.RegistrationService;

@Controller
public class HomeController {
	private ApplicationService appSvc;
	private RegistrationService regSvc;
	private CourseRepository crsRepo;
	
	@Autowired
	public HomeController(ApplicationService appSvc, RegistrationService regSvc,
			CourseRepository crsRepo) {
		this.appSvc = appSvc;
		this.regSvc = regSvc;
		this.crsRepo = crsRepo;
	}
	
	@RequestMapping("/")
	public String showWelcome() {
		return "WelcomePage";
	}
	
	@RequestMapping("/Apply")
	public String apply() {
		return appSvc.getResponsePage();
	}
	
	@RequestMapping("/Register")
	public String register() {
		return regSvc.getResponsePage();
	}
	
	@RequestMapping("/Courses")
	public String instructorPage(Model model) {
		model.addAttribute("courses", crsRepo.getCourses());
		return crsRepo.getResponsePage();
	}
}