package com.revature.advancedconcepts;

public class StringBuilderObject {
	/*
	 * 16. Create a StringBuilder object. Use at least three methods to manipulate
	 * the String.
	 */
	public static void main(String[] args) {
		String sampleString = "String to be manipulated";
		StringBuilder assignment = new StringBuilder(sampleString);
		System.out.println("Original String: " + assignment);
		assignment.reverse();
		System.out.println("String reversed: " + assignment);
		assignment.reverse();
		assignment.append(6);
		System.out.println("String adding number 6: " + assignment);
		assignment.deleteCharAt(24);
		assignment.deleteCharAt(23);
		System.out.println("String deleting number 6 and last letter: " + assignment);
	}

}
