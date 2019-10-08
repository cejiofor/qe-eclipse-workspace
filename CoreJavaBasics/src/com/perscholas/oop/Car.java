package com.perscholas.oop;


//Create a class in the package (right click on the package and select New -> Class) and name it Car - give it 3 attributes - make, model, yearBuilt.
//Create accessors (getters) and mutators (setters) by right-clicking in the class and selecting Source -> Generate Getters and Setters…
//Choose Select All on the right and click “OK” (keep in mind that getters and setters can be created manually without using the Source menu)




public class Car {
	private String make;
	private String model;
	private int yearBuilt;
	private int mileage;
	
	public Car() {}
	
	public Car(String make) {
		this.make = make;
	}
	public Car(String make, String model, int yearBuilt) {
		this.make = make;
		this.model = model;
		this.yearBuilt = yearBuilt;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	//Add additional attributes and methods to the Car class (remember to create getters/setters for these new attributes)
	//Methods to add: driveForward( ) increases miles by 10 and driveReverse( ) decreases miles by 10.
	//Print the miles, drive forward two times and then print the miles again - the output should be 0 and 20
	//Now drive reverse one time and then print the miles again - you should end up with 10 miles
	public void driveForward() {
		this.mileage += 10;
	}
	public void driveReverse() {
		this.mileage -= 10;
	}

	public final void finalKeyWordDemo() {
		System.out.println("Final Method Demo.");
	}
}

//Make the Car class final and try to create the class ForeignCar that extends the Car class. What happens?
//Remove the final keyword from the Car class declaration. Now create the class ForeignCar that extends the class Car.
//Create three constructors for ForeignCar which call each of the constructors from the Car class using the super keyword. Instantiate the ForeignCar class in the CarApp class using each of the three constructors inherited from the Car class.
//Add the method finalKeyWordDemo( ) to the Car class and make the method final ( ( e.g., public final void finalKeyWordDemo( ) ). The method can include basic code such as System.out.println(“Final Method Demo.”);
//Now attempt to override the final method finalKeyWordDemo( )in the ForeignCar class. What happens?