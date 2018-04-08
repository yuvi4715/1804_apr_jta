package com.revature.bonus;

// Solution to hw1 bonus problem #46

public class IntSwap {
	
	public static void main(String[] args) {
		
		int a = 45, b = 67;
		
		System.out.println("Original a: " + a);
		System.out.println("Original b: " + b);
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("Swapped a: " + a);
		System.out.println("Swapped b: " + b);
	}
}
