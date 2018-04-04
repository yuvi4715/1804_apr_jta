package advancedConcepts;

import java.util.StringTokenizer;

public class Problem17 {
	
	public static void main(String[] args) {
		
		String str = new String("pickles:ketchup:mustard:onion");
		
		StringTokenizer strTknr = new StringTokenizer(str, ":");
		
		while (strTknr.hasMoreTokens()) {
			System.out.println(strTknr.nextToken());
		}
		
	}

}
