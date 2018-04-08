package com.revature.bonus;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	// Solution to hw1 bonus problem #65
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int num = r.nextInt(100);
		int counter = 0, guess;
		boolean guessCorrect = false;
		
		while (guessCorrect == false) {
			
			System.out.println("Guess a number between 0 and 99: ");
			guess = in.nextInt();
			counter++;
			
			if (guess != num) {
				
				if (guess < num) {
					System.out.println("Try higher");
				} else {
					System.out.println("Try lower");
				}
			} else {
				guessCorrect = true;
			}
		}
		
		in.close();
		
		System.out.println("You guessed right in " + counter + " tries!");
	}
}
