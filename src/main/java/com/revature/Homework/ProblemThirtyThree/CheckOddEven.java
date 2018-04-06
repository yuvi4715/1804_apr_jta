package com.revature.Homework.ProblemThirtyThree;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckOddEven {
	 public static void main(String[] args) {
		test01(System.out);
	}
	 public static void test01(PrintStream out ) {
		 out.println("Enter Number");
		 Scanner in = new Scanner(System.in);	
		int number = 0;
		if(in.hasNextInt())
			number = in.nextInt();
		if(number%2==0)
			out.println("Even");
		else 
			out.println("Odd");
	 }
}
