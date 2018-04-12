package com.revature.easycoding;

import java.util.Scanner;

//problem 32
public class CheckPassFail {

	public static void main(String[] args) {
		// get number from user
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int mark = reader.nextInt();
		reader.close();

		if (mark >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

	}

}
