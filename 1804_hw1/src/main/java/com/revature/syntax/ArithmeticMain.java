package com.revature.syntax;

// Part of the solution to hw1 problem #5

public class ArithmeticMain {

	public static void main(String[] args) {
		
		double a = 7.5, b = 2.5; 
		Arithmetic arith = new Arithmetic();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("a + b = " + arith.add(a,b));
		System.out.println("a - b = " + arith.subtract(a,b));
		System.out.println("a/b = " + arith.divide(a,b));
		System.out.println("a*b = " + arith.multiply(a,b));
	}
}
