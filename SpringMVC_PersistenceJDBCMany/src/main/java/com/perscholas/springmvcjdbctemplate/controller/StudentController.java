package com.perscholas.springmvcjdbctemplate.controller;


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

import com.perscholas.springmvcjdbctemplate.model.Student;
import com.perscholas.springmvcjdbctemplate.repositories.CourseRepository;
import com.perscholas.springmvcjdbctemplate.repositories.StudentRepository;

@Controller
public class StudentController {
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
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping(value = {"/","/allStudents"})
	public String getAllStudents(Model model) throws ClassNotFoundException, 
		IOException, SQLException {
			List<Student> allStudents = studentRepository.getAllStudents();
			model.addAttribute("allStudents", allStudents);
		return "Students";
	}
	@GetMapping("/studentForm")
	public String displayStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "StudentForm";
	}
	@PostMapping("/createStudent")
	public String createStudent(@Valid @ModelAttribute("student") 
		Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "StudentForm";
		}
		Integer studentId = studentRepository.createStudent(student);
		if (studentId == -1) {
			model.addAttribute("errorMessage", "Create student failed.");
			return "StudentForm";
		}
		System.out.println("Student ID: " + studentId);
		return "redirect:allStudents";
	}
	@GetMapping("/studentById/{id}")
	public String getStudentById(@PathVariable Integer id, Model model) 
			throws SQLException {
		Student student = studentRepository.getStudentById(id);
		if (student == null) {
			model.addAttribute("errorMessage", "Student not found.");
		} else {
			model.addAttribute("student", student);
		}
		return "StudentPage";
	}
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		Boolean result = studentRepository.deleteStudent(id);
		System.out.println(result);
		return "forward:/allStudents";
	}
	@GetMapping("/updateStudentForm/{id}")
	public String updateForm(@PathVariable Integer id, Model model) 
		throws SQLException {
		Student student = studentRepository.getStudentById(id);
		model.addAttribute("student", student);
		return "UpdateStudentForm";
	}
	@PostMapping("/updateStudent")
	public String updateStudent(@Valid @ModelAttribute("student") 
		Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "UpdateStudentForm";
		}
		Boolean updateResult = studentRepository.updateStudent(student);
		if (!updateResult) {
			model.addAttribute("errorMessage", "Edit student failed.");
			return "UpdateStudentForm";
		}
		System.out.println(updateResult);
		return "redirect:/studentById/" + student.getStudentId();
	}
	
	@GetMapping("/removeCourse")
	public String removeCourseFromStudent(@RequestParam Integer studentId, 
			@RequestParam Integer courseId) {
		Boolean removeResult = courseRepository.removeStudentFromCourse(courseId, studentId);
		System.out.println(removeResult);
		return "redirect:studentById/" + studentId;
	}
}