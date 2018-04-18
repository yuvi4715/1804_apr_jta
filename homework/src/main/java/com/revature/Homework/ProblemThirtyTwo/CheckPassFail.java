package com.revature.Homework.ProblemThirtyTwo;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckPassFail {
	 public static void main(String[] args) {
		test01(System.out);
	}
	 public static void test01(PrintStream out ) {
		 out.println("Enter Number");
		 Scanner in = new Scanner(System.in);	
		int mark = 0;
		if(in.hasNextInt())
			mark = in.nextInt();
		if(mark>50) {
			out.println("PASS");
		} else {
			out.println("FAIL");
		}
	 }
}
