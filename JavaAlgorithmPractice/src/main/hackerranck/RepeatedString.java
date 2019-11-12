package hackerranck;

import java.util.List;

public class RepeatedString {

	static long repeatedString(String s, long n) {
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
	
	static long listString(String s, long n) {
		List<String> repeatString = new ArrayList<>();
		long numReps = n/s.length();
		for (letter ){
			repeatString.add(s);
            sb.append(s);
        }
        sb.append(s.substring(0, ((int)n)%s.length()));
	}
	
	public static void main(String[] args) {
		long count = RepeatedString.repeatedString("a", 100000000);
		System.out.println(count);
	}

}
