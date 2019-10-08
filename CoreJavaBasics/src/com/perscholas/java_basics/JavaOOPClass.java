package com.perscholas.java_basics;

public class JavaOOPClass {
	public static void oopPractice(){
		
	}

//	Object & Class Variables
//	Create a package inside the src folder of your class exercise project (e.g., JavaBasics, etc.) called com.perscholas.objects_class_variables. Inside the package create a class called ClassOne. Create four String attributes inside ClassOne named string1, string2, string3 and string4. Omit the access modifier for string1, and make string2 public, string3 protected and string4 private. Create a no-arg constructor which assigns a string to each variable (e.g., string1 = “String One”;). Next, create getters and setters for the private attribute. Create another class inside this package called VariablesApp and include a main method.

//	    Instantiate ClassOne in the VariablesApp1 class and try to print out each attribute using dot notation (e.g., System.out.println(classOne.string1) ). You should get an error when trying to print out string4 because it is private. Be sure you understand why this happens. Correct the problem user an accessor (i.e., getter). Now you should be able to print out all four attributes.
	
//	    Create a new package in the same src folder and name it com.perscholas.object_class_variables2. Create a class with a main method inside this package and name it VariablesApp2. Copy the content of the main method of VariableApp and paste it inside the main method of VariableApp2. You should get an error with string1 because it’s access is default (which is accessible within the same package), and with string3 because its access is protected (accessible within the same package and its subclasses) and we are outside the package for ClassOne. The String string2 is public so it has no error associated with it and string4 is being accessed through a public getter method so it has no error as well. To fix this we would change and access specifiers to public if we want string1 and string3 to be visible outside of the package.
	
//	Create a new package in your exercise project named com.perscholas.cafe. Create a class named Product inside this package with four private attributes (name, price, description, quantity). The class should also include a no-arg constructor and a constructor which takes three arguments for name, price and description. Next, create getters and setters and include a method named calculateProductTotal( ) which calculates the product subtotal for the order. Create a driver class (i.e., class that includes a main method) named CafeApp which uses the Scanner class to prompt the user for the quantity of each product and then prints the name, description and product subtotal for each, followed by the sales subtotal, sales tax and then the final sales total.


//	Inheritance & Abstract Classes
//	Make the Product class in the previous cafe exercise an abstract class and make the method calculateProductSubtotal in the Product class an abstract method. Now create three new classes (Coffee, Espresso, Cappuccino) which each extend the Product class. You will get an error in the new classes once you extend them due to the missing implementation of the calculateProductSubtotal( ) method. If you hover over the class name with this error you will be given the option to add the method. Go ahead and click the link to add the method (alternatively, you can simply write the method yourself). You should end up with an empty method with the @Override annotation. Do this for each class.

//	    In the Coffee class, add the boolean attributes, sugar and milk. Create a no-arg constructor which calls the super constructor and assigns this.milk and this.sugar to false. Create a constructor which accepts five attributes (three from Product and two from Coffee) and passes three arguments to the super constructor and assign this.milk and this.sugar to the arguments passed to the constructor. Create getters and setters for the two added attributes. Implement the calculateProductSubtotal method.
	
//	    In the Espresso class, add the boolean attributes extraShot and macchiato and complete the process as with the Coffee class. In the calculateProductSubtotal method, add $2.00 to each item with an extra shot and add $1.00 to each item made in macchiato style.
	
//	    In the Cappuccino class, add the boolean attributes peppermint and whippedCream and complete the rest of the class as with the Coffee and Espresso classes. In the calculateProductSubtotal method, add $2.00 to each item with peppermint and add $1.00 to each item with whipped cream.
//	    Rewrite the CafeApp class to utilize the Scanner class to accept orders for each product and, as before, print the name, description, quantity, and product subtotal for each item along with the sales subtotal, sales tax, and sales total.
	
	
//	We will continue the Cafe concept for this exercise.
//	    Create two new abstract methods in the Product class: addOptions() and printOptions(); Implement these methods in each of the subclasses.
	
//	    Write a program that prompts the user to select products from the cafe and select options attached to those products (e.g, "Would you like sugar with the coffee?"), but this time include store and shopping cart classes and include classes for each item (you may use the classes created in previous exercises and add these products to lists in the store and shopping cart classes). Options may or may not incur additional cost, but you should have at least one product that has options which do incur additional cost. Have the user select items from the store and add them to the shopping cart. Print out a list of each item with price, quantity and item subtotal along with the purchase subtotal, sales tax and purchase total after the user is done selecting items (i.e., there should be a choice on the menu to “check out” at which time the purchase totals are displayed and the application quits.
//	Sample Output:
//	Please select from the following menu:
//	1: Coffee
//	2: Cappuccino
//	3: Espresso
//	4: Check Out

//	Proceed to checkout.
//	Item:	Espresso	Price: 3.99	Qty: 1	 Subtotal: 4.99
//		Extra Shot: No	Machiatto: Yes (Add $1)
//	Item:	Cappuccino	Price: 4.99	Qty: 1	 Subtotal: 7.99
//		Peppermint: Yes (Add $2)	Whipped Cream: Yes (Add $1)
//	Item:	Coffee	Price: 3.49	Qty: 1	 Subtotal: 3.49
//		Sugar: Yes	Milk: Yes
//	Purchase Subtotal: 16.47
//	Sales Tax: 1.03
//	Purchase Total: 17.50

	
//	Java I/O
//	Software Developer Club
//	This next exercise requires a printout of a list of members of a software developer club by reading a text file and printing out the details. The text file is provided and can be downloaded through this link: members.txtPreview the document. Create three classes: ClubMember, SoftwareDeveloperClub, and ClubMemberApp. The ClubMemberApp class will drive the application. Write code in the SoftwareDeveloperClub constructor to read the text file and create an ArrayList of ClubMember objects. The output should include member name, city, state and favorite language such as this:
//	Member Name: Joan
//	Location: New York, NY
//	Favorite Language: JavaScript
	
//	Now we will enhance the Software Developer Club application to provide a menu which will give the user the option to display the club members, add a member or remove a member from the ArrayList created by the SoftwareDeveloperClub constructor. The function to display the members should produce output similar to the list in the preceding exercise (use the same text file: members.txtPreview the document). The menu should look similar to the following:
//	Select from the following menu:
//	1: Display Members
//	2: Remove Member
//	3: Add Member
//	4: Quit

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
