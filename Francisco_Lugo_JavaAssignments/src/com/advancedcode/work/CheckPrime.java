package com.advancedcode.work;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {

		int divisor;
		int n;;
		
		Scanner input = new Scanner(System.in);
		
		try {
			n = input.nextInt();
			
			for(divisor = 2; divisor <= (n/2); divisor++) {
				if((n%divisor) == 0) {
					System.out.println("The number " + n + " is not a prime number.");
					System.exit(0);
				}
			}
			
			System.out.println(n + " is a prime number");
		}
		catch(NumberFormatException e) {
			System.out.println("You did not enter a number!");
		}
		input.close();
	}

}
