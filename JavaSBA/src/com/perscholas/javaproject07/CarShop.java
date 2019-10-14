package com.perscholas.javaproject07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//JavaSBAProject_07
//
//Write an application that includes a Car class with ID, price and description. Write a menu which allows the user to select a car to buy and print the invoice to the console.  The invoice should include tax (6%), title fee ($150), and license fee (1.5%) along with purchase total.


public class CarShop {
	final double TAX_RATE = 0.06;
	final double TITLE_FEE = 150.00;
	final double LICENSE_FEE_RATE = 0.015;
	
	public void purchase(Car car){
		double license_fee = car.getPrice()*this.LICENSE_FEE_RATE;
		double subtotal = car.getPrice()+license_fee+this.TITLE_FEE;
		double sales_tax = car.getPrice()*this.TAX_RATE;
		double total = subtotal + sales_tax;
		
		String invoice = String.format("Car Purchase Invoice:%n"
				+ "Car: %s, Inventory ID: %d%n"
				+ "MSRP: $%.2f%n"
				+ "License Fee (1.5%%): $%.2f%n"
				+ "Title Fee: $%.2f%n"
				+ "Subtotal: $%.2f%n"
				+ "Sales Tax (6%%): $%.2f%n"
				+ "Total: $%.2f%n", car.getDescription(), car.getID(), car.getPrice(), license_fee, this.TITLE_FEE, subtotal, sales_tax, total);
		
		System.out.println(invoice);
	}
	public static void main(String[] args) {
		CarShop newShop = new CarShop();
		List<Car> inventory = new ArrayList<Car>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		Car hondaOne = new Car(1, 22000,"Honda Acoord 2019");
		Car hondaTwo = new Car(2, 32000,"Honda Civic 2019");
		Car totytaOne = new Car(3, 12000,"Toyota Corolla 2014");
		Car teslaOne = new Car(4, 102000,"Tesla Model X 2020");
		
		inventory.add(hondaOne);
		inventory.add(hondaTwo);
		inventory.add(totytaOne);
		inventory.add(teslaOne);
		
		String menu = ("Select your car from the following list:\n");
		String carListing;
		sb.append(menu);
		for (Car car: inventory) {
			carListing = String.format("%d. Car: %s   Price: %.2f%n",car.getID(), car.getDescription(), car.getPrice());
			sb.append(carListing);
		}
		System.out.println(sb.toString());
		int carSelection = sc.nextInt();
		newShop.purchase(inventory.get(carSelection-1));
		sc.close();
	}
	
	
	
	
}
