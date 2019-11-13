package hackerranck;

import java.util.List;

public class RepeatedString {
	static long repeatedString(String s, long n) {
        long count =0;
        for (int i=0; i<s.length(); i++) {
        	if (s.charAt(i) == 'a') {
        		count++;
        	}
        }
        
        long numReps = n/s.length();
        count *= numReps;
        
        int remainder = (int)n%s.length();
        for (int i=0; i<remainder; i++) {
        	if (s.charAt(i) == 'a') {
        		count++;
        	}
        }
        return count;
        
    }
	
	static long repeateddString(String s, long n) {
        long count =0;
        for (String letter: s.split("")) {
        	if (letter.equals("a")) {
        		count++;
        	}
        }
        long numReps = n/s.length();
        int remainder = (int)n%s.length();
        count *= numReps;
        
        for(String letter: s.substring(0, remainder).split("")){
        	if (letter.equals("a")) {
        		count++;
        	}
        }
        return count;
        
    }
	
	static long listString(String s, long n) {
		StringBuilder sb = new StringBuilder();
        long numReps = n/s.length();
        for (int i=0; i<numReps; i++){
            sb.append(s);
        }
        sb.append(s.substring(0, ((int)n)%s.length()));

        long count = 0;
        for (String letter: sb.toString().split("")){
            if (letter.equals("a")){
                count++;
            }
        }

        return count;
	}
	
	public static void main(String[] args) {
		long count = RepeatedString.repeatedString("a", 100000000);
		System.out.println(count);
	}

}
