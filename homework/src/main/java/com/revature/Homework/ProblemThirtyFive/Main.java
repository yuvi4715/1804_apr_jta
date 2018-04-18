package com.revature.Homework.ProblemThirtyFive;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);	
		int iNumber = 0;
		double dNumber = 0.0d;
		String s = null;
		System.out.println("Enter Number");
		if(in.hasNextInt())
			iNumber = in.nextInt();
		System.out.println("Enter Double Presicion");
		if(in.hasNextDouble())
			dNumber = in.nextDouble();
		in.nextLine();
		System.out.println("Enter String");
		if(in.hasNextLine())
			s=in.nextLine();
		System.out.println("Integer "+iNumber);
		System.out.println("Double "+dNumber);
		System.out.println("String " + s);
	}
}
