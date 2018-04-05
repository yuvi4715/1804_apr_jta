package com.revature.easycodingexercises;

// Solution to hw1 problem #34

public class PrintNumberInWord {

	// Implement using nested if-statements
	public static void printNumberIf(int number) {
		
		if (number == 1) {
			System.out.println("ONE");
		} else if (number == 2) {
			System.out.println("TWO");
		} else if (number == 3) {
			System.out.println("THREE");
		} else if (number == 4) {
			System.out.println("FOUR");
		} else if (number == 5) {
			System.out.println("FIVE");
		} else if (number == 6) {
			System.out.println("SIX");
		} else if (number == 7) {
			System.out.println("SEVEN");
		} else if (number == 8) {
			System.out.println("EIGHT");
		} else if (number == 9) {
			System.out.println("NINE");
		} else {
			System.out.println("OTHER");
		}
	}
	
	// Implement using switch case
	public static void printNumberSwitch(int number) {
		
		switch (number) {
			case 1: System.out.println("ONE");
			 		break;
			case 2: System.out.println("TWO");
	 				break;
			case 3: System.out.println("THREE");
	 				break;
			case 4: System.out.println("FOUR");
	 				break;
			case 5: System.out.println("FIVE");
	 				break;
			case 6: System.out.println("SIX");
	 				break;
			case 7: System.out.println("SEVEN");
	 				break;
			case 8: System.out.println("EIGHT");
	 				break;
			case 9: System.out.println("NINE");
	 				break;
			default: System.out.println("OTHER");
	 				break;
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
		// Test if-statement implementation
		System.out.println("Testing if-statement implementation...");
		printNumberIf(0);
		printNumberIf(1);
		printNumberIf(2);
		printNumberIf(3);
		printNumberIf(4);
		printNumberIf(5);
		printNumberIf(6);
		printNumberIf(7);
		printNumberIf(8);
		printNumberIf(9);
		printNumberIf(107);
		
		// Test switch-case implementation
		System.out.println("\nTesting switch-case implementation...");
		printNumberSwitch(0);
		printNumberSwitch(1);
		printNumberSwitch(2);
		printNumberSwitch(3);
		printNumberSwitch(4);
		printNumberSwitch(5);
		printNumberSwitch(6);
		printNumberSwitch(7);
		printNumberSwitch(8);
		printNumberSwitch(9);
		printNumberSwitch(107);
	}
}
