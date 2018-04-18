package com.revature.Homework.ProblemThirtyFour;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		test01(System.out);
	 }
	 public static void test01(PrintStream out) {
		 Scanner in = new Scanner(System.in);	
		int number = 0;
		out.println("Enter Number");
		if(in.hasNextInt())
			number = in.nextInt();
		if(number==1) {
			out.println("One");
		} else if(number==2) {
			out.println("Two");
		} else if(number==3) {
			out.println("Three");
		} else if(number==4) {
			out.println("Four");
		} else if(number==5) {
			out.println("Five");
		} else if(number==6) {
			out.println("Six");
		} else if(number==7) {
			out.println("Seven");
		} else if(number==8) {
			out.println("Eight");
		} else if(number==9) {
			out.println("Nine");
		} else{
			out.println("Other");
		}
		switch(number) {
		case 1:
			out.println("One");
			break;
		case 2:
			out.println("Two");
			break;
		case 3:
			out.println("Three");
			break;
		case 4:
			out.println("Four");
			break;
		case 5:
			out.println("Five");
			break;
		case 6:
			out.println("Six");
			break;
		case 7:
			out.println("Seven");
			break;
		case 8:
			out.println("Eight");
			break;
		case 9:
			out.println("Nine");
			break;
		default:
			out.println("Other");
			break;
		}
	}
}