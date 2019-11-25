package com.perscholas.travelcorps.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession; //TOMACATE HTTPSESSION
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.perscholas.travelcorps.dao.UserDAO;
import com.perscholas.travelcorps.models.User;
import com.perscholas.travelcorps.repositories.UserRepository;
import com.perscholas.travelcorps.repositories.impl.MariaDbUserRepository;

@Controller
@SessionAttributes
public class UserController {
//	private UserRepository userRepository = new MariaDbUserRepository();
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String showDefault(Model model) {
		model.addAttribute("user", new User());
		return "LoginPage";
	}
	
	@GetMapping("/showLogin")
	public String showLogin() {
		return "LoginPage";
	}
	
//	@PostMapping("/loginUser")
//	public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session,
//			Model model) throws SQLException, ClassNotFoundException, IOException {
//		System.out.println(username);
//		System.out.println(password);
//		User user = userRepository.getUserByName(username);
//		if (user!= null) {
//			if (password.equals(user.getPassword())) {
//				session.setAttribute("currentUser", user);
//				return "redirect:/showWelcome";
//			} 
//			else {
//				model.addAttribute("errorMessage", "Invalid Password");
//				return "LoginPage";
//			}
//		}
//		else {
//			model.addAttribute("errorMessage", "Invalid User");
//			return "LoginPage";
//		}
//	}
		
	@PostMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) throws ClassNotFoundException, IOException, SQLException{
		if (result.hasErrors()) {
			return "LoginPage";
		}
		String testUserName = user.getUserName();
		String password = user.getPassword();
		user = userRepository.getUserByName(testUserName);
		
		if (user != null) {
			if (user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "redirect:/showWelcome";
			} 
			else {
				model.addAttribute("errorMessage", "Invalid Password");
				return "LoginPage";
			}
		}
		else {
			model.addAttribute("errorMessage", "Invalid User");
			return "LoginPage";
		}
	}
	
	@GetMapping("/showWelcome")
	public String showWelcome(Model model) {
		model.addAttribute("user", new User());
		return "WelcomePage";
	}
	
	@GetMapping("/showRegistration")
	public String showRegistration(Model model) {
		model.addAttribute("user", new User());
		return "RegistrationPage";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) throws SQLException, ClassNotFoundException, IOException {
		String userName = user.getUserName();
		String password = user.getPassword();
		Boolean primeContact = user.getPrimeContact();
		User u = new User(userName, password, primeContact);
		Integer i = userRepository.registerUser(u);
		u.setUserId(i);
		System.out.println(i);
		return "redirect:/"; //clears the form, prevent resumbmission of data
		//also allows us to perform logic on the the data after submission.
	}
}
