package com.revature.syntax;

import java.util.concurrent.ThreadLocalRandom;

public class ControlStatements {

	public static void main(String[] args) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, 100);
		
		System.out.println();
		
		if (randomNum < 34) {
			System.out.println("Random Option 1");
		} else if (randomNum < 67) {
			System.out.println("Random Option 2");
		} else {
			System.out.println("Random Option 3");
		}
	}
}
