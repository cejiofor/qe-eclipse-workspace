package com.platform.dsalgorithm;

import java.util.regex.Pattern;;

public class StringAlg{
    public static void main(String[] args) {
        StringAlg sa = new StringAlg();
        String demo = "Hello 2019 QE02!"; //don't have to use the new keyword with strings
        String demo2 = demo.concat("qwerty");
        System.out.println(demo.subSequence(0, 2));
        System.out.println(demo2);
        System.out.println(demo.contains("John"));
        // demo.split(regex) - returns sstring slipt around regens
//        z. qe = new Regex("Q");
        // System.out.println(demo.split("Q"));
        String[] strArr = demo.split(" ");
        for (String str: strArr){
            System.out.println(str);
        }
    }
    
    public String returnWord() {
    	return "dig";
    }
    
    
}

