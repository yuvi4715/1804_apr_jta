package com.advancedConcepts.work;

import java.util.StringTokenizer;
import java.lang.Runtime;

public class StringExample {

	public static void main(String[] args) {
		String s3 = "2";
		String s4 = "2";
		char g = 'f';
		String s2 = "pickles:ketchup:mustard:onion";
		
		buildStrings(g);
		token(s2);
		addStrings(s3,s4);
		runMethod();
		
		System.gc();
	}
	
	private static void runMethod() {
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(Runtime.getRuntime().freeMemory());
		Runtime.getRuntime().gc();
	}

	private static void token(String s2) {
		StringTokenizer  str = new StringTokenizer(s2, ":");
		
		while(str.hasMoreTokens()){
			System.out.println(str.nextToken());
		}
	}

	public static void buildStrings(char g) {
		
		StringBuilder s1 = new StringBuilder("This is the string builder");
		s1.length();
		System.out.println(s1);

		System.out.println(s1.substring(3, 10));
		s1.setCharAt(5, g);
		System.out.println(s1);
	}
	
	
	public static void addStrings(String p1, String p2) {
		String s4 = p1 + p2;
		System.out.println(s4);
	}
}
