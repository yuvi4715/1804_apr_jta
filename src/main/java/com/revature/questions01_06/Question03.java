package com.revature.questions01_06;

public class Question03 {

	
	public static void main(String[] args) {
		
		boolean_fun();
	}
	
	
	public static void boolean_fun() {
		
		boolean a = true;
		boolean b = false;
		
		System.out.print("!a: ");
		System.out.println(!a);
		System.out.print("a|b: ");
		System.out.println(a|b);
		System.out.print("(!a & b) | (a & !b): ");
		System.out.println((!a & b) | (a & !b));
	}
}
