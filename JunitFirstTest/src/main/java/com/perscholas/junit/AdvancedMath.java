package com.perscholas.junit;
import java.util.HashMap;
import java.util.Map; 

// 3. Hamcrest: Write a class that includes 5 methods with a combination of math functions that return values and other methods that return lists and maps. Use at least 10 different Hamcrest matchers to test the methods.
public class AdvancedMath {

	BasicMath bm = new BasicMath();
	
	public AdvancedMath() {
	}
	
	public double fx(double x, double slope, double intercept) {
		return bm.add((int) intercept, (int) bm.multiply(slope, x)); 
	};
	
	public double average(int[] array) {
		int total = 0;
		for(int i: array) {
			total = bm.add(i, total);
		}
		return bm.divide((double) total, array.length); 
	}
	
	public int power(int num, int pow) {
		int total = 1;
		for(int i =0; i<pow; i++) {
			total = (int) bm.multiply((double) num, (double) total);
		}
		return total; 
	}
	
	public Map<Double, Double> spacedPoints(double slope, double intercept, int numPoints){
		AdvancedMath am = new AdvancedMath();
		Map<Double, Double> points = new HashMap<Double, Double>();
		double xf = 10;
		double deltaX = 10.0/numPoints;
		double xi = 0;
		while (xi <= xf) {
			points.put((Double) xi, (Double) am.fx(xi, slope, intercept));
			xi += deltaX;
		}
		
		return points;
	}
	 
}

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class HamcrestClass {
       
    public static int sum(int x, int z){
        
        return x+z;
}
    public static int sub(int x, int z){
        
        return x-z;
}
    public static int mult(int x, int z){
        
        return x*z;
}
    public static List<String> listNames(){
        
        List<String> mylist = new ArrayList<>();
        
        mylist.add("Amira");
        mylist.add("Gabby");
        mylist.add("Charlie");
        
        return mylist;
        
        
    }
    
    public static Map<Integer,String> mapName(){
        
        Map<Integer,String> mymap = new HashMap<>();
        mymap.put(4, "Amira");
        mymap.put(3, "Gabby");
        mymap.put(2, "Charlie");
    
        return mymap;
    }
    
     
    
    
}
*/


