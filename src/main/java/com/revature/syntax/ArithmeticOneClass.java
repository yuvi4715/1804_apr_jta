package com.revature.syntax;

//Answer for hw1 problem #4

public class ArithmeticOneClass {

	double add(double a, double b) {
		return a+b;
	}
	
	double subtract(double a, double b) {
		return a-b;
	}
	
	double divide(double a, double b) {
		return a/b;
	}
	
	double multiply(double a, double b) {
		return a*b;
	}
	public static void main(String[] args) {
		
		double a = 5.0, b = 6.0; 
		ArithmeticOneClass arith = new ArithmeticOneClass();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a + b = " + arith.add(a,b));
		System.out.println("a - b = " + arith.subtract(a,b));
		System.out.println("a/b = " + arith.divide(a,b));
		System.out.println("a*b = " + arith.multiply(a,b));	
		
	}
}
