package com.perscholas.javaproject05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//JavaSBAProject_05
//Create an application that includes a menu to add or remove strings to a list and a menu item that displays the list and a final menu item to quit.

public class ListMenu {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int menuItem;
		String menu = ("Select from the following menu:\n"
				+ "1: Add String to List\n"
				+ "2: Remove String from List\n"
				+ "3: Display List of Strings\n"
				+ "4: Quit Application");
		String newString = null;
		
		do {
			System.out.println(menu);
			System.out.print("Option: ");
			menuItem = sc.nextInt();
			switch (menuItem){
			case 1:
				System.out.print("Type String to be added: ");
				sc.nextLine();
				newString = sc.nextLine();
				stringList.add(newString);
				System.out.printf("String: '%s' Added!%n", newString);
				break;
			case 2:
				int index = 1;
				for (String s: stringList) {
					System.out.printf("String #%d: %s%n",index,s);
					index++;
				}
				System.out.println("Select string to be removed: ");
				int removeIndex = sc.nextInt();
				stringList.remove(removeIndex-1);
				break;
			case 3:
				System.out.println(stringList.toString());
				break;
			case 4:
				break;
			default:
				System.out.println("Not a valid selection, try again!");
				
			}
			System.out.println();
		} while (menuItem != 4);
		
		
		sc.close();
	}
}
