package com.revature.AdvancedConcepts;

import java.util.StringTokenizer;

//problem 16, 17, 18, 19

public class StringExpo {
	
	static public int addStringInts(String s1, String s2) {
		System.gc();
		int x = Integer.parseInt(s1);
		int y = Integer.parseInt(s2);
		
		return x + y;
		
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("My StringBuilder test!");
		sb.deleteCharAt(3);
		sb.append("I guess this should work");
		sb.insert(8, "    ");
		
		String s = "pickles:ketchup:mustard:onion";
		StringTokenizer st = new StringTokenizer(s,":");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		String sNum1 = "20", sNum2 = "15";
		
		System.out.println(addStringInts(sNum1,sNum2));
		
		
	}

}
