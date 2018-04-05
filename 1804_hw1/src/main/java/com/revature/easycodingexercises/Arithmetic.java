package com.revature.easycodingexercises;

public class Arithmetic {

	public static void main(String[] args) {
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		String operator = args[2];
		int result;
		
		if (operator.equals("+")) {
			result = num1 + num2;		
			System.out.println(result);
		} else if (operator.equals("-")) {
			result = num1 - num2;		
			System.out.println(result);
		} else if (operator.equals("'*'")) { // Must use '*' instead of * because command line 
											 //	uses the * character for something else
			
			result = num1 * num2;		
			System.out.println(result);
		} else if (operator.equals("/")) {
			result = num1 / num2;		
			System.out.println(result);
		}
		
		Integer.parseInt("asdfasdf");
	}
}
