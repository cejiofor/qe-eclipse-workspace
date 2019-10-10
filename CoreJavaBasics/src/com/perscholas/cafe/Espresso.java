package com.perscholas.cafe;

public class Espresso extends Product {
	private Boolean extraShot;
	private Boolean macchiato;
	
	public Espresso(){
		super();
		this.setName("Espresso");
		this.setDescription("An espresso");
		this.setPrice(3.75);
		this.extraShot = false;
		this.macchiato = false;
	}
	
	public Espresso(String name, double price, String description, Boolean extraShot, Boolean macchiato){
		super(name, price, description);
		this.extraShot = false;
		this.macchiato = false;
	}

	public Boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(Boolean extraShot) {
		this.extraShot = extraShot;
	}

	public Boolean getMacchiato() {
		return macchiato;
	}

	public void setMacchiato(Boolean macchiato) {
		this.macchiato = macchiato;
	}
	
	@Override
	public double calculateProductTotal() {
		double extraOptions = 0.00;
		if (this.getExtraShot()) {
			extraOptions += 2.00; 
		}
		if (this.getMacchiato()) {
			extraOptions += 1.00; 
		}
		return this.getPrice()*this.getQuantity()+extraOptions;
	}

	@Override
	public void addOptions(Boolean addShot, Boolean addMacc) {
		// TODO Auto-generated method stub
		this.setExtraShot(addShot);
		this.setMacchiato(addMacc);
	}

	@Override
	public String printOptions() {
		String shotStatus;
		String maccStatus;
		
		if (this.getExtraShot()) {
			shotStatus = "Yes (Add $2)";
		} else {
			shotStatus = "No";
		}
		
		if (this.getMacchiato()) {
			maccStatus = "Yes (Add $1)";
		} else {
			maccStatus = "No";
		}

		String printOut = String.format("\tExtra Shot %s   Macchiato: %s",shotStatus, maccStatus);
		return printOut;
	}

}
