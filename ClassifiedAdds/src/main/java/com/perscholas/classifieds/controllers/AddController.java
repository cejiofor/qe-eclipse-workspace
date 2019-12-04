package com.perscholas.classifieds.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.perscholas.classifieds.models.Add;
import com.perscholas.classifieds.models.User;
import com.perscholas.classifieds.repositories.AddRepository;
import com.perscholas.classifieds.repositories.UserRepository;

@RequestMapping("/adds")
@Controller
public class AddController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddRepository addRepository;
	
	@GetMapping(value = {"/","/allAdd"})
	public String getAllAdds(Model model) throws ClassNotFoundException, IOException, SQLException {
		List<Add> allAdds = addRepository.getAllAdds();
		model.addAttribute("allAdds", allAdds);
		return "Adds";
	}
	
	@GetMapping("/addForm")
	public String displayAddForm(Model model) {
		model.addAttribute("add", new Add());
		return "AddForm";
	}
	
	@PostMapping("/createAdd")
	public String createAdd(@Valid @ModelAttribute("add") 
		Add add, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "AddForm";
		}
		Integer addId = addRepository.createAdd(add);
		if (addId == -1) {
			model.addAttribute("errorMessage", "Create add failed.");
			return "AddForm";
		}
		System.out.println("Add ID: " + addId);
		return "redirect:/adds/allAdds";
	}
	
	@GetMapping("/addById/{id}")
	public String getAddById(@PathVariable Integer id, Model model) throws SQLException {
		Add add = addRepository.getAddById(id);
		if (add == null) {
			model.addAttribute("errorMessage", "Add not found.");
		} else {
			model.addAttribute("add", add);
		}
		return "AddPage";
	}
	@GetMapping("/deleteAdd/{id}")
	public String deleteCourse(@PathVariable Integer id) {
		Boolean result = addRepository.deleteAdd(id);
		System.out.println(result);
		return "forward:/add/allAdds";
	}
	@GetMapping("/updateAddForm/{id}")
	public String updateAdd(@PathVariable Integer id, Model model) throws SQLException {
		Add add = addRepository.getAddById(id);
		model.addAttribute("add", add);
		return "UpdateAddForm";
	}
	@PostMapping("/updateAdd")
	public String updateAdd(@Valid @ModelAttribute("add") 
		Add add, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "UpdateAddForm";
		}
		Boolean updateResult = addRepository.updateAdd(add);
		if (!updateResult) {
			model.addAttribute("errorMessage", "Edit add failed.");
			return "UpdateAddForm";
		}
		System.out.println(updateResult);
		return "redirect:/adds/addById/" + add.getAddId();
	}
	@GetMapping("/courseEnrollment")
	public String courseEnrollmentForm(Model model) throws 
		ClassNotFoundException, IOException, SQLException {
		List<User> allUsers = userRepository.getAllUsers();
		List<Add> allAdds = addRepository.getAllAdds();
		model.addAttribute("allUsers", allUsers);
		model.addAttribute("allAdds", allAdds);
		model.addAttribute("enrollmentViolations", model.asMap().get("enrollmentViolations"));
		model.addAttribute("successEnrollmentMessage", model.asMap().get("successEnrollmentMessage"));
		return "CourseEnrollmentForm";
	}
//	@PostMapping("/enrollInCourse")
//	public String enrollInCourse(@RequestParam Integer userId, 
//			@RequestParam Integer addId, Model model, RedirectAttributes 
//			redirectAtt) throws SQLException {
//		List<String> enrollmentViolations = new ArrayList<>();
//		// Check to see if student is already enrolled in course
//		List<Add> enrollmentChecklist = addRepository.getAddsByUserId(userId);
//		if (!enrollmentChecklist.isEmpty()) {
//			for (Add a: enrollmentChecklist) {
//				if (a.getAddId() == addId) {
//					enrollmentViolations.add("User has already purchased " 
//                                        + a.getItem() + ".");
//				}
//			}
//		}
//		// Check if maximum size is exceeded
//		Add registeredAdd= addRepository.getAddById(addId);
//		if (registeredAdd.getRoster().size() >= registeredCourse.getMaxSize()) {
//			enrollmentViolations.add("Course maximum size exceeded.");
//		}
//		if (!enrollmentViolations.isEmpty()) {
//			redirectAtt.addFlashAttribute("enrollmentViolations", enrollmentViolations);
//			return "redirect:/courses/courseEnrollment";
//		}
		// Proceed with enrollment if there are no errors
//		Integer enrollId = addRepository.enrollInAdd(userId, addId);
//		System.out.println("Enroll ID: " + enrollId);
//		redirectAtt.addFlashAttribute("successEnrollmentMessage", 
//				"Student successfuly enrolled in " 
//				+ registeredCourse.getName() + ".");
//		return "redirect:/courses/courseEnrollment";
//	}
//	@GetMapping("/removeUser")
//	public String removeUserFromAdd(@RequestParam Integer addId, 
//			@RequestParam Integer userId) {
//		Boolean removeResult = addRepository.removeUserFromAdd(addId, userId);
//		System.out.println(removeResult);
//		return "redirect:addById/" + addId;
//	}
}
