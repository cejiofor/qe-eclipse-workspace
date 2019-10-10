package com.perscholas.devclub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftwareDeveloperClub {
	private List<ClubMember> members = new ArrayList<>();
	
	public SoftwareDeveloperClub() throws IOException {
		File memberList = new File("members.txt");
		FileReader fr = new FileReader(memberList);
		BufferedReader br = new BufferedReader(fr);
		String[] lineArr;
		ClubMember newMember;
		
		try
		{
			String memberTxt = br.readLine();
			while (memberTxt != null) {
				lineArr = memberTxt.split("\\*\\*");
				if (lineArr[0].equals("NAME")) {
					memberTxt = br.readLine();
					continue;
				}
//				System.out.println(Arrays.toString(lineArr));
				newMember = new ClubMember(lineArr[0],lineArr[1], lineArr[2],lineArr[3]);
				members.add(newMember);
				memberTxt = br.readLine();
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

//		File memberList = new File("members.txt");
//		FileReader fr = new FileReader(memberList);
//		BufferedReader br = new BufferedReader(fr);
//		String memberTxt = br.readLine();
//		while (memberTxt != null) {
//			String[] lineArr = memberTxt.split("\\*\\*");
//			if (lineArr[0].equals("NAME")) {
//				memberTxt = br.readLine();
//				continue;
//			}
//			System.out.println(Arrays.toString(lineArr));
////			;
////			newMember.printMemberInfo();
//			members.add(new ClubMember(lineArr[0],lineArr[1], lineArr[2],lineArr[3]));
//			memberTxt = br.readLine();
//		}
//		for (ClubMember member: members) {
//			member.printMemberInfo();
//		}
	}
	public void displayMembers() {
		for (ClubMember member: members) {
			member.printMemberInfo();
		}
	}
	public void removeMember(Scanner userInput) {
		System.out.print("Enter a member name: ");
		String name = userInput.next();
		Boolean validName = checkName(name);
		
		while(!validName) {
			System.out.print("Member does not exist, enter a valid member:");
			name = userInput.next();
			validName = checkName(name);
		}
		ClubMember removedMember = memberByName(name);
		System.out.printf("Member: %s from %s, %s has been removed%n",removedMember.getName(), removedMember.getCity(),removedMember.getState());
		members.remove(removedMember);
		
	}
	
	public ClubMember memberByName(String name) {
		for (ClubMember member :members) {
			if (member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}
	
	public Boolean checkName(String name) {
		int nameMatch = 0;
		for (ClubMember member :members) {
			if (member.getName().equals(name)) {
				nameMatch += 1;
			}
		}
		if (nameMatch > 0){
			return true;
		}
		return false;
	}
	public void addMember(Scanner userInput) {
		String name;
		String city;
		String state;
		String language;
		System.out.print("Enter new member's name: ");
		name = userInput.next();
		System.out.print("Enter new member's city: ");
		city = userInput.next();
		System.out.print("Enter new member's state: ");
		state = userInput.next();
		System.out.print("Enter new member's favorite language: ");
		language = userInput.next();
		ClubMember addNewMember = new ClubMember(name, city, state, language);
		members.add(addNewMember);
		System.out.println("\nNew member added! Member Info:");
		addNewMember.printMemberInfo();
	}
	public List<ClubMember> getMembers() {
		return members;
	}
	public void setMembers(List<ClubMember> members) {
		this.members = members;
	}
}
