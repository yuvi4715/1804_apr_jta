package com.revature.easycodingexercises;

public class Arithmetic {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No arguments were provided");
		} else {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			String operator = args[2];
			
			if (operator.equals("+")) {
				System.out.println(a + b);
			} else if (operator.equals("-")) {
				System.out.println(a - b);
			} else if (operator.equals("*")) {
				System.out.println(a * b);
			} else if (operator.equals("/")) {
				System.out.println(a / b);
			} else {
				System.out.println("Not a valid operator");
			}
		}
		
		
		
	}
}
