package com.perscholas.javaiopractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quiz {
	public static void runQuiz() throws IOException {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter Your Name: ");
		String name = userInput.nextLine();
		File inputFile = new File("quiz.txt");
		String fileName = String.format("Answers_%s.txt", name);
		File outputFile = new File(fileName);
		
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String newLineRegex =  "^\\s*$";
		Pattern newLinePattern = Pattern.compile(newLineRegex);
		
		String ansRegex = "A|B|C|D";
		Pattern ansPattern = Pattern.compile(ansRegex);
		String answer = null;
		
		try
		{
			fr = new FileReader(inputFile);
			fw = new FileWriter(outputFile);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			bw.write("Name: "+name+"\n");
			String line = br.readLine();
			int questNum = 1;
			
			while (line != null) {
				Matcher matcher = newLinePattern.matcher(line);
				if (matcher.find()){
					System.out.print("Enter your answer: ");
					answer = userInput.next();
					
					
					Matcher ansMatch = ansPattern.matcher(answer);
					while(!ansMatch.find()) {
						System.out.println("Invalid Reponse! Must be A, B, C, or D");
						System.out.print("Enter your answer: ");
						answer = userInput.next();
						ansMatch = ansPattern.matcher(answer);
					}
					
					System.out.println("Q"+questNum+" Answer: "+answer+"\n");
					bw.write("Q"+questNum+" Answer: "+answer+"\n");
					questNum++;
					
					
				}
				else {
					System.out.println(line);
				}
				line = br.readLine();

			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{

			if (br != null) {
				fr.close();
				br.close();
			}
			if (bw != null) {
				bw.flush();
				fw.close();
				bw.close();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		runQuiz();
	}
}
