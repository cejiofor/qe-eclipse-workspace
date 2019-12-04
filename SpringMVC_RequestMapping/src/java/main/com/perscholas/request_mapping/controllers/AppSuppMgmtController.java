package com.perscholas.request_mapping.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appSuppMgmt")
public class AppSuppMgmtController {
	private String course = "Application Support Management";
	private String displayPage = "PerScholasHome";
	
	@RequestMapping("/")
	public String defaultView(Model model) {
		model.addAttribute("heading", course);
		return displayPage;
	}
	@RequestMapping("/courseId")
	public String showCourseId(Model model) {
		model.addAttribute("heading", course);
		model.addAttribute("message", "2019-DAL-02");
		return displayPage;
	}
	@RequestMapping("/location")
	public String showLocation(Model model) {
		model.addAttribute("heading", course);
		model.addAttribute("message", "Irving");
		return displayPage;
	}
}
