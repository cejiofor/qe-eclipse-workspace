package org.platform.firstclass;

public class House {
	
	private int bedrooms;
	private int bathrooms;
	private int area;
	private String type;
	private String color;
	
	
	public House(int bedrooms, int bathrooms, int sqFt, String type, String color) {
		this.bathrooms = bathrooms;
		this.bedrooms = bedrooms;
		this.area = sqFt;
		this.type = type;
		this.color = color;
	}
	
	public void getInfo() {
		System.out.println("Home Type: "+this.type);
		System.out.println("Area: "+this.area+" sq ft");
		System.out.println("Rooms: "+ this.bedrooms+ "/"+this.bathrooms +" BR/BA" );
		System.out.println("Color: "+this.color);
	}
	
	public void addBedRooms(int numOfBedRooms) {
		this.bedrooms += numOfBedRooms;
	}
	
	public void addBathRooms(int numOfBathRooms) {
		this.bathrooms += numOfBathRooms;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House myHouse = new House(5,4,4000,"Single Family","Brown");
		myHouse.getInfo();
	}

}
