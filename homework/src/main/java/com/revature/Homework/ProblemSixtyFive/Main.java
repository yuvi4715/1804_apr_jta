package com.revature.Homework.ProblemSixtyFive;

import java.util.Scanner;

public class Main {
	private static final int NUMBER_OF_ATEMPTS = 3;
	public static void main(String[] args) {
		int randomValue = 1+(int)(Math.random()*100);
		Scanner in = new Scanner(System.in);
		int atemps = NUMBER_OF_ATEMPTS;
		System.out.println("Welcome to the guessing game!");
		while(atemps--!=0) {	
			int guess=0;
			System.out.println("please enter your guess (atemptsleft:"+atemps+"): ");
			if(in.hasNextInt())
				guess = in.nextInt();
			else {
				System.out.println("You did not enter a number");
				break;
			}
			if(guess>randomValue)
				System.out.println("Too High");
			else if(guess<randomValue)
				System.out.println("Too Low");
			else {
				System.out.println("Correct Starting new game");
				atemps=NUMBER_OF_ATEMPTS;
				continue;
			}
		}
		
	}
}
