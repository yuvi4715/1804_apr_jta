package com.revature.corejava;

public class CoreJava {

	public static void main(String[] args) {
		System.out.println(addTwo(2, 3));
		System.out.println(addTwo(5, 3));
		System.out.println(multiplyTwo(3, 4));
		System.out.println(divideTwo(10, 2));
		declareTwoVariables();
		System.out.println(max(-3, -5, 1));
	}
	
	// Question 1
	
	public static int addTwo(int a, int b) {
		return a + b;
	}
	
	public static int subtractTwo(int a, int b) {
		return a - b;
	}
	
	public static int multiplyTwo(int a, int b) {
		return a * b;
	}
	
	public static int divideTwo(int a, int b) {
		return a / b;
	}
	
	// Question 2
	
	public static int max(int a, int b, int c) {
		if (a > b && a > c) {
			return a;
		} else if (b > a && b > c) {
			return b;
		} else {
			return c;
		}
	}
	
	// Question 3
	static void declareTwoVariables() {
		boolean a = true;
		boolean b = false;
		
		System.out.println(!a);
		System.out.println(a | b);
		System.out.println((!a & b) | (a & !b));

	}
	

}
