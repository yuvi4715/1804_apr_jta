package com.revature.hello;

import java.util.StringTokenizer;

public class AdvConcepts {
	// Advanced Concepts

	
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello");
		
		// 16 Create a StringBuilder object. Use at least three methods to manipulate the
		// String.
		sb.append("w");
		sb.deleteCharAt(0);
		sb.reverse();
		
		
		System.out.println(sb);

		// 17 Create a new String with delimited tokens, such as
		// “pickles:ketchup:mustard:onion” and use StringTokenizer to parse out and
		// print each token.
		String s = "pickles:ketchup:mustard:onion";
		StringTokenizer st = new StringTokenizer(s, ":");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

		// 18 Create two String objects with number values (i.e. “20). Write a method that
		// adds the two.
		String s1 = "20";
		String s2 = "30";
		System.out.println(addStrings(s1, s2));
		
		// 19 Request garbage collection in your method.
		System.gc();
		
		// 20 Create a Runtime object and note at least three methods. Imagine how you
		// would use them.
		Runtime r = Runtime.getRuntime();
		System.out.println(r.availableProcessors());
		System.out.println(r.freeMemory());
		System.out.println(r.totalMemory());
		r.exit(0);
		
	}
	
	public static int addStrings(String s1, String s2) {
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}
	
	
	
}
