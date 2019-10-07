package com.perscholas.regexpractice;

import java.util.Scanner;
import java.util.regex.*;

public class UserValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserValidation newUser = new UserValidation();
		System.out.println("Enter username");
		Scanner input = new Scanner(System.in);
		String username = input.next();
		System.out.println("Enter password");
		String password = input.next();
		newUser.validateUser(username);
		newUser.validatePassword(password);
		
		
	}
	public void validateUser(String usrName) {
		String regex = "\\p{Alpha}{8}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(usrName);
		if (matcher.matches()){
			System.out.println("Valid User");
		}
		else {
			System.out.println("Invalid Username");
		}	
	}
	public void validatePassword(String password) {
		String regex = "\\p{Alpha}+\\d+||\\d+\\p{Alpha}+\\w{4,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()){
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Invalid Password");
		}	
	}

}
