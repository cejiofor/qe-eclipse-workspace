package com.perscholas.request_mapping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PerScholasController {
	@RequestMapping("/")
	public String welcomeMessage(Model model) {
		model.addAttribute("heading", "Welcome to Per Scholas!");
		return "PerScholasHome";
	}
}