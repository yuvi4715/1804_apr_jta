package com.revature.EasyCodingExercises;

public class Questions32Through37 {

	public static void main(String[] args) {
		MethodsECE m = new MethodsECE();
		
		//Question 36
		if(args.length != 3) {
			System.out.println("Error - invalid number of command line inputs");
		}
		else {
			m.Arithmetic(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2].charAt(0));
		}
	}
}
