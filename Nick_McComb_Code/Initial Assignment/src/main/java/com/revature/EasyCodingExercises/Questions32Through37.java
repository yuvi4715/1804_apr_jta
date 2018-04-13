package com.revature.EasyCodingExercises;

public class Questions32Through37 {

	public static void main(String[] args) {
		MethodsECE m = new MethodsECE();
		
		System.out.println("Question 32: Checking number size");
		System.out.println(m.CheckPassFail(51));
		System.out.println(m.CheckPassFail(22));
		
		System.out.println("Question 33: Checking even or odd");
		System.out.println(m.CheckEvenOdd(200));
		System.out.println(m.CheckEvenOdd(199));

		System.out.println("Question 34: Printing numbers");
		m.PrintNumberInWord(5);
		
		System.out.println("Question 35: Taking user input");
		m.KeyboardScanner();
		
		//Question 36
		System.out.println("Question 36: Command line arguments (note - needs command line arguments)");
		if(args.length != 3) {
			System.out.println("Error - invalid number of command line inputs");
		}
		else {
			m.Arithmetic(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2].charAt(0));
		}
		
		System.out.println("Question 37: Grading statistics");
		m.GradesStatistics(20, 90, 99, 87, 80, 66);	
	}
	
}
