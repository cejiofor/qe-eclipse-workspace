package com.perscholas.springmvcjdbctemplate.controller;

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

import com.perscholas.springmvcjdbctemplate.model.Course;
import com.perscholas.springmvcjdbctemplate.model.Student;
import com.perscholas.springmvcjdbctemplate.repositories.CourseRepository;
import com.perscholas.springmvcjdbctemplate.repositories.StudentRepository;

@RequestMapping("/courses")
@Controller
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(value = {"/","/allCourses"})
	public String getAllCourses(Model model) throws ClassNotFoundException, 
		IOException, SQLException {
			List<Course> allCourses = courseRepository.getAllCourses();
			model.addAttribute("allCourses", allCourses);
		return "Courses";
	}
	@GetMapping("/courseForm")
	public String displayCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "CourseForm";
	}
	@PostMapping("/createCourse")
	public String createStudent(@Valid @ModelAttribute("course") 
		Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "CourseForm";
		}
		Integer courseId = courseRepository.createCourse(course);
		if (courseId == -1) {
			model.addAttribute("errorMessage", "Create course failed.");
			return "CourseForm";
		}
		System.out.println("Course ID: " + courseId);
		return "redirect:/courses/allCourses";
	}
	@GetMapping("/courseById/{id}")
	public String getCourseById(@PathVariable Integer id, Model model) 
			throws SQLException {
		Course course = courseRepository.getCourseById(id);
		if (course == null) {
			model.addAttribute("errorMessage", "Course not found.");
		} else {
			model.addAttribute("course", course);
		}
		return "CoursePage";
	}
	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable Integer id) {
		Boolean result = courseRepository.deleteCourse(id);
		System.out.println(result);
		return "forward:/courses/allCourses";
	}
	@GetMapping("/updateCourseForm/{id}")
	public String updateForm(@PathVariable Integer id, Model model) 
		throws SQLException {
		Course course = courseRepository.getCourseById(id);
		model.addAttribute("course", course);
		return "UpdateCourseForm";
	}
	@PostMapping("/updateCourse")
	public String updateCourse(@Valid @ModelAttribute("course") 
		Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "UpdateCourseForm";
		}
		Boolean updateResult = courseRepository.updateCourse(course);
		if (!updateResult) {
			model.addAttribute("errorMessage", "Edit course failed.");
			return "UpdateCourseForm";
		}
		System.out.println(updateResult);
		return "redirect:/courses/courseById/" + course.getCourseId();
	}
	@GetMapping("/courseEnrollment")
	public String courseEnrollmentForm(Model model) throws 
		ClassNotFoundException, IOException, SQLException {
		List<Student> allStudents = studentRepository.getAllStudents();
		List<Course> allCourses = courseRepository.getAllCourses();
		model.addAttribute("allStudents", allStudents);
		model.addAttribute("allCourses", allCourses);
		model.addAttribute("enrollmentViolations", model.asMap().get("enrollmentViolations"));
		model.addAttribute("successEnrollmentMessage", model.asMap()
				.get("successEnrollmentMessage"));
		return "CourseEnrollmentForm";
	}
	@PostMapping("/enrollInCourse")
	public String enrollInCourse(@RequestParam Integer studentId, 
			@RequestParam Integer courseId, Model model, RedirectAttributes 
			redirectAtt) throws SQLException {
		List<String> enrollmentViolations = new ArrayList<>();
		// Check to see if student is already enrolled in course
		List<Course> enrollmentChecklist = courseRepository.getCoursesByStudentId(studentId);
		if (!enrollmentChecklist.isEmpty()) {
			for (Course c : enrollmentChecklist) {
				if (c.getCourseId() == courseId) {
					enrollmentViolations.add("Student is already enrolled in " 
                                        + c.getName() + ".");
				}
			}
		}
		// Check if maximum size is exceeded
		Course registeredCourse = courseRepository.getCourseById(courseId);
		if (registeredCourse.getRoster().size() >= registeredCourse.getMaxSize()) {
			enrollmentViolations.add("Course maximum size exceeded.");
		}
		if (!enrollmentViolations.isEmpty()) {
			redirectAtt.addFlashAttribute("enrollmentViolations", enrollmentViolations);
			return "redirect:/courses/courseEnrollment";
		}
		// Proceed with enrollment if there are no errors
		Integer enrollId = courseRepository.enrollInCourse(studentId, courseId);
		System.out.println("Enroll ID: " + enrollId);
		redirectAtt.addFlashAttribute("successEnrollmentMessage", 
				"Student successfuly enrolled in " 
				+ registeredCourse.getName() + ".");
		return "redirect:/courses/courseEnrollment";
	}
	@GetMapping("/removeStudent")
	public String removeStudentFromCourse(@RequestParam Integer courseId, 
			@RequestParam Integer studentId) {
		Boolean removeResult = courseRepository.removeStudentFromCourse(courseId, studentId);
		System.out.println(removeResult);
		return "redirect:courseById/" + courseId;
	}
}