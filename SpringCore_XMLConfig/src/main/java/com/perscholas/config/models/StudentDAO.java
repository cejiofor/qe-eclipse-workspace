package com.perscholas.config.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.spring_beans.Student;

public class StudentDAO {
	private List<Student> studentList = null;
	private StudentListGenerator studentListGenerator = null;
	
	/* Class dependencies are wired in the XML configuration file (StudentAppConfig.xml). */
	public StudentDAO(ArrayList<Student> studentList,
			StudentListGenerator studentListGenerator) {
		this.studentList = studentList;
		this.studentListGenerator = studentListGenerator;
	}
	
	/* For either method */
	public List<Student> getAllStudents() throws IOException {
		studentList = studentListGenerator.generateList("StudentList.txt");
		return studentList;
	}
}
