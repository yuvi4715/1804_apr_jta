package com.revature.advancedcodingexercises;

public class ReverseString {

	/*
	 * 44. Write a method to reverse a String without using API functions.
	 */

	String reverseString(String stringReverse) {
		StringBuilder reverser = new StringBuilder();
		for (int i = stringReverse.length() - 1; i >= 0; --i)
			reverser.append(stringReverse.charAt(i));
		System.out.println(reverser);
		return reverser.toString();
	}

	public static void main(String[] args) {
		ReverseString activate = new ReverseString();
		activate.reverseString("Lemon");
	}

}
