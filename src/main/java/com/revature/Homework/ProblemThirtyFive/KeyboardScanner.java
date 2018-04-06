package com.revature.Homework.ProblemThirtyFive;

import java.io.PrintStream;
import java.util.Scanner;

public class KeyboardScanner {
	 public static void main(String[] args) {
		test01(System.out);
	 }
	public static void test01(PrintStream out) {
		Scanner in = new Scanner(System.in);	
		int iNumber = 0;
		double dNumber = 0.0d;
		String s = null;
		out.println("Enter Number");
		if(in.hasNextInt())
			iNumber = in.nextInt();
		out.println("Enter Double Presicion");
		if(in.hasNextDouble())
			dNumber = in.nextDouble();
		in.nextLine();
		out.println("Enter String");
		if(in.hasNextLine())
			s=in.nextLine();
		out.println("Integer "+iNumber);
		out.println("Double "+dNumber);
		out.println("String " + s);
	}
}
