package com.revature.EasyCodingExercises;

public class CheckOddEven {
//problem 33
	public static void main(String[] args) {
		try {
			int num = Integer.parseInt(args[0]);
			if (num%2 == 0) {
				System.out.println("Even Number");
			}
			else {
				System.out.println("Odd Number");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
