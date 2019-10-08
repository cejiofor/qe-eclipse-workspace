package com.perscholas.oop;

public class ForeignCar extends Car{
	public ForeignCar() {
		super();
	}
	public ForeignCar(String make) {
		super(make);
	}
	public ForeignCar(String make, String model, int yearBuilt) {
		super(make, model, yearBuilt);
	}
	
	// Can't override final methods
//	@Override
//	public final void finalKeyWordDemo() {
//		System.out.println("Final Method Demo.");
//	}
}