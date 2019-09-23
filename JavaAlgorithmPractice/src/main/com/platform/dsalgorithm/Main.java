package com.platform.dsalgorithm;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAlg sa = new StringAlg();
		sa.printSub();
//      String demo = "Hello 2019 QE02!"; //don't have to use the new keyword with strings
//      String demo2 = demo.concat("qwerty");
//      System.out.println(demo.subSequence(0, 2));
//      System.out.println(demo2);
//      System.out.println(demo.contains("John"));
//      // demo.split(regex) - returns sstring slipt around regens
////      z. qe = new Regex("Q");
//      // System.out.println(demo.split("Q"));
//      String[] strArr = demo.split(" ");
//      for (String str: strArr){
//          System.out.println(str);
//      }
		String sample = "red,green,blue;square,triangle,circle;dog,cat,bird";
		sa.stringToArray(sample);
		sa.stringToNestedArray(sample);
	}

}
