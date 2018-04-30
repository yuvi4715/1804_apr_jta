package com.revature.easycodingexercises;

import java.util.Scanner;

public class CheckPassFail {

	public static void main(String[] args) {
		/*
		 * 32. Write a program called CheckPassFail which prints "PASS" if the int
		 * variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.
		 */
		Scanner user = new Scanner(System.in);
		System.out.println("Please enter a number to check if you pass or fail: ");
		int mark = user.nextInt();
		if (mark >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		user.close();
	}

}
