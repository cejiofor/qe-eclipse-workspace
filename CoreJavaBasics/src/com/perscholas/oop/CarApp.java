package com.perscholas.oop;
// Create another class and call it CarApp - check the box to include the “public static void main(String[ ] args)” method (if you forget to do this you can write the method yourself inside the class - see the example below). This will be the driver class since it will contain a main method
//Create an instance of the Car class in the main method of the driver class
//
//Now let’s assign some values to the attributes/fields
//car.setMake("Ford");
//
//car.setModel(“Mustang");
//
//car.setYearBuilt(2017);
//
//Now retrieve these values and print them
//
//Output:
//
//Ford
//
//Mustang
//
//2017
//


public class CarApp {

	public static void main(String[] args) {
		Car newCar = new Car();
		newCar.setMake("Ford");
		newCar.setModel("Mustang");
		newCar.setYearBuilt(2017);
		
		System.out.printf("My Car: Make: %s, Model: %s, Year: %d%n",newCar.getMake(), newCar.getModel(),newCar.getYearBuilt());
		
		
		//Create 3 constructors for the Car class: One no-arg constructor, another which accepts only the year built, and another which accepts all fields of the class.
		//Now create three instances of the Car class using each of the three constructors available and assign values to the attributes either through the constructors or by using setter methods. Test the attributes/fields of each instance by printing out some getter methods (e.g., make, model and year built).
		Car carOne = new Car();
		carOne.setMake("Ford");
		carOne.setModel("Focus");
		carOne.setYearBuilt(2016);
		
		Car carTwo = new Car("Chevorlet");
		carTwo.setModel("Bolt");
		carTwo.setYearBuilt(2017);
		
		Car carThree = new Car("Dodge", "Challenger", 2018);
		
		
		System.out.printf("Make: %s, Model: %s, Year: %d%n",carOne.getMake(), carOne.getModel(),carOne.getYearBuilt());
		System.out.printf("Make: %s, Model: %s, Year: %d%n",carTwo.getMake(), carTwo.getModel(),carTwo.getYearBuilt());
		System.out.printf("Make: %s, Model: %s, Year: %d%n",carThree.getMake(), carThree.getModel(),carThree.getYearBuilt());
		
		ForeignCar fCarOne = new ForeignCar();
		fCarOne.setMake("Nissan");
		fCarOne.setModel("Altima");
		fCarOne.setYearBuilt(2019);
		
		ForeignCar fCarTwo = new ForeignCar("Toyota");
		fCarTwo.setModel("Camry");
		fCarTwo.setYearBuilt(2018);
		
		ForeignCar fCarThree = new ForeignCar("Honda", "Accord", 2017);
		
		System.out.printf("Make: %s, Model: %s, Year: %d%n",fCarOne.getMake(), fCarOne.getModel(),fCarOne.getYearBuilt());
		System.out.printf("Make: %s, Model: %s, Year: %d%n",fCarTwo.getMake(), fCarTwo.getModel(),fCarTwo.getYearBuilt());
		System.out.printf("Make: %s, Model: %s, Year: %d%n",fCarThree.getMake(), fCarThree.getModel(),fCarThree.getYearBuilt());
		
	}

}
