package com.perscholas.config.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.spring_beans.Student;

public class StudentListGenerator {
	private Student student = null;
	private List<Student> studentList = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private String studentInfo = null;
	private String[] studentInfoArr = null;
	
	/* Class dependencies are wired in the XML configuration file (StudentAppConfig.xml). */
	public StudentListGenerator(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public List<Student> generateList(String filePath) throws IOException {
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			br.readLine(); // This clears the first line which consists of headers
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		while ( (studentInfo = br.readLine() ) != null) {
			studentInfoArr = studentInfo.split(",");
			student = new Student();
			student.setName(studentInfoArr[0]);
			student.setPassword(studentInfoArr[1]);
			student.setCourse(studentInfoArr[2]);
			studentList.add(student);
		}
		return studentList;
	}
}
