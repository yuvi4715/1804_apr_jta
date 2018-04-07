package com.revature.hello;

public class Fibonacci {
	// Write a Java program to print the first 100 Fibonacci numbers using
	// iteration. Rewrite using recursion.

	public static void main(String[] args) {
		fibIterative();
		
	}
	
	public static void fibIterative() {
		System.out.println("Fiboniacci sequence calculated iteratively: ");

		long former = 0;
		long latter = 1;
		for (int i = 0; i < 90; ++i) {
			long num = latter + former;
			former = latter;
			latter = num;
			System.out.println(num);
		}
	}
}
