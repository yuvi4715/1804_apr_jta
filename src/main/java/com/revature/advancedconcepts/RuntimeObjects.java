package com.revature.advancedconcepts;

public class RuntimeObjects {

	public static void main(String[] args) {
		/*
		 * 20. Create a Runtime object and note at least three methods. Imagine how you
		 * would use them.
		 */
		Runtime runTimeObject = Runtime.getRuntime();
		System.out.println("Amount of free memory available: " + runTimeObject.freeMemory());
		System.out.println("The amount of available processors: " + runTimeObject.availableProcessors());
		System.out.println("The total amount of memory in the JVM: " + runTimeObject.totalMemory());
		
	}

}
