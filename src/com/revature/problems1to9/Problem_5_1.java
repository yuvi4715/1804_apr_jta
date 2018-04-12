package com.revature.problems1to9;

import java.util.Scanner;

public class Problem_5_1 {

	public static void main(String[] args) {
		//create an instance of problem 5_2 which will contain methods
		Problem_5_2 problem_5_2 = new Problem_5_2();
		
		
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter value 1");
		float val_1 = reader.nextFloat();
		System.out.println("Enter value 2");
		float val_2 = reader.nextFloat();
		
		float result = problem_5_2.add(val_1, val_2);
		System.out.println(val_1 + " + " + val_2 + " = " + result);
		result = problem_5_2.subtract(val_1, val_2);
		System.out.println(val_1 + " - " + val_2 + " = " + result);
		result = problem_5_2.multiply(val_1, val_2);
		System.out.println(val_1 + " * " + val_2 + " = " + result);
		result = problem_5_2.divide(val_1, val_2);
		System.out.println(val_1 + " / " + val_2 + " = " + result);
		reader.close();
	}

}
