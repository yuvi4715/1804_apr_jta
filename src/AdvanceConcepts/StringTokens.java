package AdvanceConcepts;

import java.util.StringTokenizer;

public class StringTokens {

	public static void main(String[] args) {
		
		StringTokens st = new StringTokens();
		st.StringTokens();
		

	}
	
	public void StringTokens() {
		
		String s = "Hell;every;one";
		StringTokenizer s1 = new StringTokenizer(s, ";");
		
		while(s1.hasMoreTokens()) {
			System.out.println(s1.nextToken());
		}
	}

}
