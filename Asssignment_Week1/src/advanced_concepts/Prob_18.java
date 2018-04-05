package advanced_concepts;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Concepts - Problem 18, 19, 20.
//This class contains an example of what happens when you add to strings,
//and how to request the garbage collector. It also shows an example of a Runtime object
//and some of its methods.

public class Prob_18 {
	public static void main(String[] args) {
		String num1 = "20";
		String num2 = "40";
		System.out.println(addStrings(num1, num2));
		
		//Request the garbage collector
		System.gc();
		
		//Runtime object and some of its methods.
		Runtime run = Runtime.getRuntime();
		System.out.println("Amount of free memory in the JVM: " + run.freeMemory());
		System.out.println("Amount of total memory available in the JVM: " + run.totalMemory());
		System.out.println("Amount of available processors in the JVM: " + run.availableProcessors());
	}
	
	public static String addStrings(String str1, String str2) {
		return str1 + str2;
	}
}
