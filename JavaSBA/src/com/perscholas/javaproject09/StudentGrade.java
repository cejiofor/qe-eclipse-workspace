package com.perscholas.javaproject09;
//JavaSBAProject_09
//
//Write a Student Grading application with the following requirements:
//The application should read each student's name from a text file.
//The application should allow the user to enter a score (double) for each student in the console.
//The application should save each student's name with their grade into a text file.
//The application should show the following information at the end of the output text file:
//Highest Score
//Lowest Score
//Average Score

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class StudentGrade {
	
	public StudentGrade() throws IOException {
		
		
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<String> students = new ArrayList<String>();
		List<String> studentRecord = new ArrayList<String>();
		List<Double> scores = new ArrayList<Double>();
		File inputFile = new File("students.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try
		{
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			String studentName = br.readLine();
			while (studentName != null) {
				students.add(studentName);
				studentName = br.readLine();
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			if (br != null) {
				fr.close();
				br.close();
			}
		}
		
		
		File outputFile = new File("student_scores.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		double scoreTotal = 0.00;
		double score = 0.00;
		
		try
		{
			fw = new FileWriter(outputFile);
			bw = new BufferedWriter(fw);
			for (String student : students) {
				System.out.printf("Enter a score for %s: ",student);
				score = sc.nextDouble();
				studentRecord.add("Name: "+student+", Score: "+score+"\n");
				scores.add(score);
				scoreTotal += score;
			}
			for (String s: studentRecord) {
				bw.write(s);
			}
			String highScore = "Highest Score: "+Collections.max(scores);
			String lowScore = "Lowest Score: "+Collections.min(scores);
			String avgScore = String.format("Average Score: %.2f%n",scoreTotal/scores.size());
			System.out.println(highScore + lowScore + avgScore);
			bw.write(highScore+"\n");
			bw.write(lowScore+"\n");
			bw.write(avgScore+"\n");
			
		}
		
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if (bw != null) {
				bw.flush();
				fw.close();
				bw.close();
			}
			sc.close();
		}
		
		
		
	}

}
