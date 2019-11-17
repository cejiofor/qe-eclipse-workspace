package com.perscholas.config.setget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.spring_beans.Student;

public class StudentDAO {
	/* This class will use the default constructor and inject dependencies through
	 * setter methods based on the configuration file "StudentAppConfig.xml" */
	private List<Student> studentList = null;
	private StudentListGenerator studentListGenerator = null;
	public StudentDAO() {
		
	}
	/* Setter methods will receive parameters/arguments from
	 * the Spring framework based on the relevant bean definitions. */
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	public void setStudentListGenerator(StudentListGenerator studentListGenerator) {
		this.studentListGenerator = studentListGenerator;
	}

	
	/* For either method */
	public List<Student> getAllStudents() throws IOException {
		studentList = studentListGenerator.generateList("StudentList.txt");
		return studentList;
	}
}
