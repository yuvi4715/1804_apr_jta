package com.revature.EasyCodingExercises;

public class Arithmetic {
//problem 36
	public static void main(String[] args) {
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			String operator = args[2];
			int check = 0;
			
			switch(operator) {
			case "+":
				check = num1 + num2;
				System.out.println(check);
				break;
			case "-":
				check = num1 - num2;
				break;
			case "*":
				check = num1 * num2;
				break;
			case "/":
				check = num1/num2;
				break;
			}
			System.out.println("Result: " + check);
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
