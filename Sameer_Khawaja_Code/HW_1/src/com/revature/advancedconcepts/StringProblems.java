package com.revature.advancedconcepts;

import java.util.StringTokenizer;

//problems 16-20

//20 stuck
public class StringProblems {

	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("String Builder");
		System.out.println(str);
		
		str.append(" append");
		System.out.println(str);
		
	
		str.setCharAt(str.lastIndexOf("a", str.length()), 'A');
		System.out.println(str);
		
		str.deleteCharAt(str.length()-1);
		System.out.println(str+"\n");
		
		String strtoken = new String("pickles:ketchup:mustard:onion");
		
		StringTokenizer tokenizer = new StringTokenizer(strtoken, ":");
		while(tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
		
		String A = new String("20");
		String B = new String("20");
		
		
		System.out.println(SumString(A,B));
		
	
		
		
	}
	
	
	
	
	public static int SumString(String A, String B) {
		
		int A_as_int = Integer.parseInt(A);
		int B_as_int = Integer.parseInt(B);
		
		System.gc();
		
		return A_as_int + B_as_int;
	}

}
