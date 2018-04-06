package com.revature.advancedCodingExercises;

public class StringReverse {
	//problem 44
	public static String stringReverser(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = s.length() -1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
}
