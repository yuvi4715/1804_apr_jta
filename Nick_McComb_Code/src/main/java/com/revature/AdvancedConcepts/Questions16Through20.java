package com.revature.AdvancedConcepts;

public class Questions16Through20 {

	public static void main(String[] args) {
		Methods q = new Methods();
		System.out.println("Question 16:");
		q.q16();
		System.out.println("\nQuestion 17:");
		q.q17();
		System.out.println("\nQuestion 18:");
		System.out.println("ten plus twenty is " + q.q18("10", "20"));
		System.out.println("\nQuestion 19: Calling the garbage collector...");
		System.gc();
		System.out.println("\nQuestion 20: getting the runtime object to look at...");
		Runtime rt = Runtime.getRuntime();
		/*I could use the freeMemory method to determine how much memory is used / not used at 
		 * a given point in the program, which could be useful, especially when used in conjunction with
		 * the maxMemory method to determine the cap
		 * I could use the halt method in a dead end error block to force the error to end the program
		 * I could use 
		 */
	}
	
}
