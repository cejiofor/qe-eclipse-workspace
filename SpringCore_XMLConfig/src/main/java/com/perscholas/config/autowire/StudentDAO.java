package com.perscholas.config.autowire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.perscholas.spring_beans.Student;

public class StudentDAO {
	@Autowired
	private ArrayList<Student> studentList = null;
	@Autowired
	private StudentListGenerator studentListGenerator = null;
	public StudentDAO() {
		
	}
	
	public List<Student> getAllStudents() throws IOException {
		studentList = (ArrayList<Student>) studentListGenerator.generateList("StudentList.txt");
		return studentList;
	}
}
