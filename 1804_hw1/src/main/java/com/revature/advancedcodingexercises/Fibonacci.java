package com.revature.advancedcodingexercises;

// Solution to hw1 problem #40

import java.math.BigInteger;

public class Fibonacci {

	public static void fibonacci() {
		
		 BigInteger currFib;
		 BigInteger prevNum1 = BigInteger.ZERO;
		 BigInteger prevNum2 = BigInteger.ONE;
		
		 System.out.println(prevNum1);
		 System.out.println(prevNum2);
		 
		for (int i = 0; i < 98; i++) {
			
			currFib = prevNum1.add(prevNum2);
			
			System.out.println(currFib);
			
			prevNum1 = prevNum2;
			prevNum2 = currFib;
		}
	}
	
	public static void fibonacciRecursive() {
		
		BigInteger prevNum1 = BigInteger.ZERO;
		BigInteger prevNum2 = BigInteger.ONE;
		
		System.out.println(prevNum1);
		System.out.println(prevNum2);
		
		int counter = 2;
		fibonacciRecursive(prevNum1, prevNum2, counter);
	}
	
	public static void fibonacciRecursive(BigInteger prevNum1, BigInteger prevNum2, int counter) {
		
		BigInteger currFib = prevNum1.add(prevNum2);
		counter++;
		
		System.out.println(currFib);
		
		prevNum1 = prevNum2;
		prevNum2 = currFib;
		
		if (counter > 99) {
			return;
		}
		
		fibonacciRecursive(prevNum1, prevNum2, counter);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Non-Recursive here:");
		fibonacci();
		System.out.println("Recursive here:");
		fibonacciRecursive();
	}
}
