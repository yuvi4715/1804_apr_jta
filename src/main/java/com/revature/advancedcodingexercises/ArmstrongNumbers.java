package com.revature.advancedcodingexercises;

import java.util.Scanner;

public class ArmstrongNumbers {
	public static void main(String[] args) {
		/*
		 * 43. Write a Java program to check if a number is Armstrong or not.
		 */
		int sumOfCubes = 0;
		int cube, check;
		Scanner user = new Scanner(System.in);
		System.out.println("Please type a number to check if it is Armstrong: ");
		int armstrongNumber = user.nextInt();
		check = armstrongNumber;
		while (armstrongNumber > 0) {
			cube = armstrongNumber % 10;
			armstrongNumber = armstrongNumber / 10;
			sumOfCubes = sumOfCubes + (cube * cube * cube);
		}
		if (check == sumOfCubes)
			System.out.println("This number is an Armstrong Number!");
		else
			System.out.println("This number is not an Armstrong Number.");
		user.close();
	}
}
