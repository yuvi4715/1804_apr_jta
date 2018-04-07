package com.revature.easycoding;

public class CommandLineArgs {

	public static void main(String[] args) {
//		
		int numOne = Integer.parseInt(args[0]);
		int numTwo = Integer.parseInt(args[1]);
		String operatorTemp = args[2];
		char operator = operatorTemp.charAt(0);
		double result;

		switch (operator) {
		case '+':
			result = numOne + numTwo;
			System.out.println(numOne + " + " + numTwo + " = " + result);
			break;
		case '-':
			result = numOne - numTwo;
			System.out.println(numOne + " - " + numTwo + " = " + result);
			break;
		case '*':
			result = numOne * numTwo;
			System.out.println(numOne + " * " + numTwo + " = " + result);
			break;
		case '/':
			result = numOne / numTwo;
			System.out.println(numOne + " / " + numTwo + " = " + result);
			break;
		default:
			System.out.println("Invalid Operator...");
			break;
		}
	}

}
