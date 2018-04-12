package com.java.advancedcoding;

import java.util.Scanner;

//problem 45
public class Prime {

	public static void main(String[] args) {
		int temp;
		boolean isPrime = true;
		// get user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = scanner.nextInt();
		scanner.close();

		for (int i = 2; i <= num / 2; i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(num + " is prime");

		} else {
			System.out.println(num + " is not prime");
		}

	}

}
