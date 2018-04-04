package com.revature.Homework.ProblemThirtySix;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		if(args.length<3) {
			System.out.println("Need three parameters");
			System.exit(0);
		}
		double numberOne = Double.parseDouble(args[0]);
		double numberTwo = Double.parseDouble(args[1]);
		switch(args[2]) {
		case "+":
			System.out.println(numberOne+numberTwo);
			break;
		case "/":
			System.out.println(numberOne/numberTwo);
			break;
		case "*":
			System.out.println(numberOne*numberTwo);
			break;
		case "-":
			System.out.println(numberOne-numberTwo);
			break;
		}
	}
}

