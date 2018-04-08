package com.revature.easycoding;

import java.util.Scanner;
//problem 33
public class CheckOddEven {

	public static void main(String[] args) {
		//get number from user
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int mark = reader.nextInt(); 
		reader.close();

		//check if number is even or odd
		if (mark % 2 == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}

	}

}
