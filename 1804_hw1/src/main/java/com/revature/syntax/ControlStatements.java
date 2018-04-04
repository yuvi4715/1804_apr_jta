package com.revature.syntax;

import java.util.concurrent.ThreadLocalRandom;

public class ControlStatements {

	public static void main(String[] args) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		
		System.out.println("If-Statement Example:");
		
		if (randomNum < 34) {
			System.out.println("Random Option 1");
		} else if (randomNum < 67) {
			System.out.println("Random Option 2");
		} else {
			System.out.println("Random Option 3");
		}
		
		System.out.println("\nFor Loop Example:");
		
		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}
		
		System.out.println("\nWhile/Do-While Loop Example:");
		
		int cond = 1;
		
		//Never runs because of while condition
		while (cond == 0) {
			System.out.println("This while loop has just run"); 
		}
		
		// Runs once because condition is not checked until after the loop block
		do {
			System.out.println("This do-while loop has just run");
		} while (cond == 0);
		
		System.out.println("\nSwitch-Case/Break Example:");
		
		randomNum = ThreadLocalRandom.current().nextInt(1, 4);
		
		switch (randomNum) {
			case 1: System.out.println("Random Switch-Case 1");
					break;
			case 2: System.out.println("Random Switch-Case 2");
					break;
			case 3: System.out.println("Random Switch-Case 3");
					break;
		}
		
		System.out.println("\nContinue Example:");
		
		int oddCount = 0;
		
		// counts number of 
		for (int i = 1; i < 11; i++) {
			
			if (i%2 == 0) {
				continue;
			}
			
			oddCount++; // Only run if the above continue statement does not get hit
		}
		
		System.out.println("There are " + oddCount + " odd numbers between 1 and 10");
	}
}
