package com.revature.hello;

public class reverseStr {

	// Write a method to reverse a String without using API functions.
	public static void main(String[] args) {
		String s = "Buitrago";

		System.out.println(reverse(s));
	}

	public static String reverse(String s) {
		int len = s.length();
		char[] reversed = new char[len];

		for (int i = 0; i < len; ++i) {
			reversed[len - 1 - i] = s.charAt(i);
		}
		return new String(reversed);
	}
}
