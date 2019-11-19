package com.perscholas.springmvc_jpa.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.springmvc_jpa.model.Course;

public interface CourseRepository {
	Integer createCourse(Course course);
	Course getCourseById(Integer id) throws SQLException;
	List<Course> getCoursesByStudentId(Integer studentId);
	List<Course> getAllCourses() throws ClassNotFoundException, IOException, SQLException;
	Integer enrollInCourse(Integer studentId, Integer courseId);
	Boolean updateCourse(Course course);
	Boolean deleteCourse(Integer courseId);
	Boolean removeStudentFromCourse(Integer courseId, Integer studentId);
}