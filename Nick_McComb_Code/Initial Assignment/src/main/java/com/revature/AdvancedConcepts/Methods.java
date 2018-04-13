package com.revature.AdvancedConcepts;

import java.util.StringTokenizer;

public class Methods {

	void q16() {
		StringBuilder s = new StringBuilder("Question 16 StringBuilder");
		System.out.println(s);
		s.append(" is a StringBuilder");
		System.out.println("appending: " + s);
		System.out.println("Deleting the first ten characters of the StringBuilder: " + s.delete(0, 10));
		System.out.println("Inserting Hello World into the middle of the StringBuilder: " + s.insert(8, "Hello World"));
	}
	
	void q17() {
		String toppings = "pickles:ketchup:mustard:onion";
		System.out.println("Hamburger toppings not yet tokenized: " + toppings);
		StringTokenizer st = new StringTokenizer(toppings, ":");
		System.out.println("Tokenizing...");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
	
	int q18(String s1, String s2) {
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		return i2+i1;
	}
}
