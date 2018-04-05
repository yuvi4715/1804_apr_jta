package com.revature.easycodingexercises;

// Solution to hw1 problem #35

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {
		
		Scanner inScanner = new Scanner(System.in);
		
		System.out.println("Enter and integer: ");
		int intIn = inScanner.nextInt(); 
		
		System.out.println("Enter a double: ");
		double doubIn = inScanner.nextDouble();
		
		System.out.println("Enter a string: ");
		String stringIn = inScanner.next();
		stringIn += inScanner.nextLine();
		
		System.out.println("Integer: " + intIn);
		System.out.println("Double: " + doubIn);
		System.out.println("String: " + stringIn);
		
		inScanner.close();
	}
}
