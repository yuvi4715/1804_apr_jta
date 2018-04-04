package com.revature.corejava;

// Answer for hw1 question #3

public class BooleanOperators {

	public static void main(String[] args) {
		
		boolean a = true;
		boolean b = false;
		
		System.out.println("a = true");
		System.out.println("b = false");
		System.out.println("!a = " + !a);
		System.out.println("a | b = " + (a|b));
		System.out.println("(!a & b) | (a & !b) = " + ((!a&b)|(a&!b)));
	}
}
