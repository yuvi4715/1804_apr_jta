package com.revature.Homework.ProblemThirtySix;

import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		if(args.length<3)
		{
			String[] a = {
				"1.0",
				"34.56",
				"+"
			};
			test01(System.out,a);
		} else 
			test01(System.out,args);
	}
	public static void test01(PrintStream out, String[] args) {
		if(args.length<3) {
			out.println("Need three parameters");
			System.exit(0);
		}
		double numberOne = Double.parseDouble(args[0]);
		double numberTwo = Double.parseDouble(args[1]);
		switch(args[2]) {
		case "+":
			out.println(numberOne+numberTwo);
			break;
		case "/":
			out.println(numberOne/numberTwo);
			break;
		case "*":
			out.println(numberOne*numberTwo);
			break;
		case "-":
			out.println(numberOne-numberTwo);
			break;
		}
	}
}

