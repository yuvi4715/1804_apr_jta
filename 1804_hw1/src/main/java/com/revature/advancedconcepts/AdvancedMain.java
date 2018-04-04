package com.revature.advancedconcepts;

import java.util.StringTokenizer;

// Solutions to hw1 problems #16 - #20

public class AdvancedMain {

	public static int addNumStrings(String a, String b) {
		int aInt = Integer.parseInt(a);
		int bInt = Integer.parseInt(b);
		
		// Solution to hw1 problem #19
		System.gc();
		
		return aInt + bInt;
	}
	
	public static void main(String[] args) {
		
		// Solution to hw1 problem #16
		
		StringBuilder sb = new StringBuilder("This is a test string");
			
		System.out.println("Original StringBuilder Object: ");
		System.out.println(sb);
		
		sb.append(", it is not a joke!");
		
		System.out.println("\nAfter Append: ");
		System.out.println(sb);
		
		sb.delete(10, 35);
		
		System.out.println("\nAfter Delete: ");
		System.out.println(sb);
		
		sb.reverse();
		
		System.out.println("\nAfter Reverse: ");
		System.out.println(sb);
		
		// Solution for hw1 problem #17
		
		String tokenString = "Bagels:Donuts:Cereal:Toast:Fruit:Eggs";
		StringTokenizer tokenizer = new StringTokenizer(tokenString, ":");
		
		System.out.println("\nOriginal String: ");
		System.out.println(tokenString);
		
		System.out.println("\nAfter StringTokenizer: ");
		
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
		
		// Solution for hw1 problem #18
		
		String numString1 = "23";
		String numString2 = "64";
		
		System.out.println("\nString a = " + numString1 + "\nString b = " 
							+ numString2);
				
		System.out.println("a + b = " + addNumStrings(numString1, numString2));
		
	}
}
