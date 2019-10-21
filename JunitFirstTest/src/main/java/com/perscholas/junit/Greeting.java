package com.perscholas.junit;

public abstract class Greeting {
	public String selectLanguage(Integer i) {
		switch(i) {
			case 1:
				return "English";
			case 2:
				return "Spanish";
			case 3:
				return "Chinese";
			case 4:
				return "Swahili";
			default:
				return "Invalid Selection";
		}
	}
	
	public abstract String selectGreeting(Integer i);

}
