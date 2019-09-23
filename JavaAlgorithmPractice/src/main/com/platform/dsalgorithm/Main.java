package com.platform.dsalgorithm;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAlg sa = new StringAlg();
		sa.printSub();
		
		String sample = "red,green,blue;square,triangle,circle;dog,cat,bird";
		
		sa.stringToArray(sample);
		sa.stringToNestedArray(sample);
	}

}
