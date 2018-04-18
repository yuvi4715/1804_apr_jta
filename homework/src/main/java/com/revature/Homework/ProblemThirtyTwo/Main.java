package com.revature.Homework.ProblemThirtyTwo;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		System.out.println("Enter Number");
		 Scanner in = new Scanner(System.in);	
		int number = 0;
		if(in.hasNextInt())
			number = in.nextInt();
		if(number>50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
	}
}
