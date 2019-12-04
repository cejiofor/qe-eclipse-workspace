package com.perscholas.config.autowireconstuctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.perscholas.spring_beans.Student;

public class StudentDAO {
	private ArrayList<Student> studentList = null;
	private StudentListGenerator studentListGenerator = null;
	
	/* This class uses a constructor to wire dependencies. */
	@Autowired
	public StudentDAO(ArrayList<Student> studentList,
			StudentListGenerator studentListGenerator) {
		this.studentList = studentList;
		this.studentListGenerator = studentListGenerator;
	}
	
	public List<Student> getAllStudents() throws IOException {
		studentList = (ArrayList<Student>) studentListGenerator.generateList("StudentList.txt");
		return studentList;
	}
}
