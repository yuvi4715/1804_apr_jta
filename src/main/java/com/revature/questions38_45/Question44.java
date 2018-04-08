package com.revature.questions38_45;

public class Question44 {

	public static void main(String[] args) {

		String test1 = "Hello";
		String test2 = "I take vitamins every day";
		String test3 = "Don't really need this third test.";
		System.out.println(reverseString(test1));
		System.out.println(reverseString(test2));
		System.out.println(reverseString(test3));
	}

	public static String reverseString(String str) {
		
		StringBuilder reverse = new StringBuilder();
		
		int max = str.length();
		for (int i = max - 1; i >= 0; --i) {
			reverse.append(str.charAt(i));
		}
		return reverse.toString();
	}

	
	public static String reverseRecurse(String s) { //I didn't write this but I liked it so I included it. Need to practice recursion. 
		if (s.length() == 0)
			return "";
		return s.charAt(s.length() - 1) + reverseRecurse(s.substring(0, s.length() - 1));
	}

}
