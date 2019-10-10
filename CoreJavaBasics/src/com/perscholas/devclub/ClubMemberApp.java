package com.perscholas.devclub;

import java.io.IOException;
import java.util.Scanner;

public class ClubMemberApp {
	public static void main(String[] args) throws IOException {
		SoftwareDeveloperClub SoftClub = new SoftwareDeveloperClub();
		int selection;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Select from the following menu:\n1: Display Members\n2: Remove Member\n3: Add Member\n4: Quit");
			System.out.print("Option: ");
			selection = sc.nextInt();
			switch (selection){
				case 1:
					SoftClub.displayMembers();
					break;
				case 2:
					SoftClub.removeMember(sc);
					break;
				case 3:
					SoftClub.addMember(sc);
					break;
				case 4:
					break;
			}
		} while(selection != 4);
		sc.close();
	}
}
