package com.perscholas.classifieds.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.classifieds.models.User;
import com.perscholas.classifieds.repositories.AddRepository;
import com.perscholas.classifieds.repositories.UserRepository;


@Controller
public class UserController {
	/* The MySqlStudentRepository is injected here based on it's type as an 
	 * implementing class of the interface StudentRepository. This works 
	 * because there are no other classes in this application which implement 
	 * the StudentRepository interface. The Spring framework searches the list 
	 * of managed beans for an instance of StudentRepository and in this case 
	 * will find only one - MariaDbStudentRepository. It then injects it here. 
	 * If another implementing class is added to the application, (e.g., 
	 * another database repository) we will need to add an "@Qualifier" 
	 * annotation to specify the StudentRepository bean we want injected here. */
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddRepository addRepository;
	
	@GetMapping(value = {"/","/allUsers"})
	public String getAllUsers(Model model) throws ClassNotFoundException, 
		IOException, SQLException {
			List<User> allUsers = userRepository.getAllUsers();
			model.addAttribute("allUsers", allUsers);
		return "Users";
	}
	@GetMapping("/userForm")
	public String displayStudentForm(Model model) {
		model.addAttribute("user", new User());
		return "UserForm";
	}
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") 
		User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "UserForm";
		}
		Integer userId = userRepository.createUser(user);
		if (userId == -1) {
			model.addAttribute("errorMessage", "Create user failed.");
			return "UserForm";
		}
		System.out.println("User ID: " + userId);
		return "redirect:allUser";
	}
	@GetMapping("/userById/{id}")
	public String getUserById(@PathVariable Integer id, Model model) 
			throws SQLException {
		User user = userRepository.getUserById(id);
		if (user == null) {
			model.addAttribute("errorMessage", "User not found.");
		} else {
			model.addAttribute("user", user);
		}
		return "UserPage";
	}
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Integer id) {
		Boolean result = userRepository.deleteUser(id);
		System.out.println(result);
		return "forward:/allUsers";
	}
	@GetMapping("/updateUserForm/{id}")
	public String updateForm(@PathVariable Integer id, Model model) 
		throws SQLException {
		User user = userRepository.getUserById(id);
		model.addAttribute("user", user);
		return "UpdateUserForm";
	}
	@PostMapping("/updateUser")
	public String updateUser(@Valid @ModelAttribute("user") 
		User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "UpdateUserForm";
		}
		Boolean updateResult = userRepository.updateUser(user);
		if (!updateResult) {
			model.addAttribute("errorMessage", "Edit user failed.");
			return "UpdateUserForm";
		}
		System.out.println(updateResult);
		return "redirect:/userById/" + user.getUserId();
	}
	
//	@GetMapping("/removeAdd")
//	public String removeAddFromStudent(@RequestParam Integer userId, 
//			@RequestParam Integer addId) {
//		Boolean removeResult = addRepository.removeUserFromCourse(addId, userId);
//		System.out.println(removeResult);
//		return "redirect:userById/" + userId;
//	}
}