package com.perscholas.exercises;

import java.util.HashMap;

public class Anagram {
	public Boolean anagramTest(String s1, String s2) {
		String[] s1Arr = s1.toLowerCase().split("");
		for (String s:s1Arr) {
			if (!s2.toLowerCase().contains(s)){
				System.out.println(s+ " false");
				return false;
			}
		}
		String[] s2Arr = s2.toLowerCase().split("");
		for (String s:s2Arr) {
			if (!s1.toLowerCase().contains(s)){
				System.out.println(s+ " false");
				return false;
			}
		}
		return true;
		
	}
	
	public Boolean betterAnagramTest(String s1, String s2) {
		Integer count = null;
		HashMap<String, Integer> hm = new HashMap();
		if (s1.length() != s2.length()) {
			System.out.println("length fail");
			return false;
			
		}
		else {
		
			for (String s: s1.toLowerCase().split("")) {
				if (hm.containsKey(s)) {
					count = hm.get(s);
					hm.replace(s, count++);
				} else {
					hm.put(s, 1);
				}
			}
			
			for (String s: s2.toLowerCase().split("")) {
				if (hm.containsKey(s)) {
					count = hm.get(s);
					hm.replace(s, count--);
				} 
			}
			
			for (Integer num: hm.values()) {
				if (num != 0) {
					return false;
				}
			}
			return true;
		}
	}
	
	
	public static void main(String[] args) {
		Anagram ana = new Anagram();
		ana.betterAnagramTest("Tasjte","State");
		ana.betterAnagramTest("Care","Rhace");
	}
}

