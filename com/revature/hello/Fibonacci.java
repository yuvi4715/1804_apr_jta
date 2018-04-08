package com.revature.hello;

public class Fibonacci {
	// Write a Java program to print the first 100 Fibonacci numbers using
	// iteration. Rewrite using recursion.

	public static void main(String[] args) {
		fibIterative(100);
		
		System.out.println("recursive : " + fibRecursive(10));

	}

	public static void fibIterative(int n) {
		System.out.println("Fiboniacci sequence calculated iteratively: ");

		double former = 0;
		double latter = 1;
		for (int i = 0; i < n; ++i) {
			double num = latter + former;
			former = latter;
			latter = num;
			System.out.println(num);
		}
	}


	public static double fibRecursive(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return fibRecursive(n - 1) + fibRecursive(n - 2);
		}
	}
}
