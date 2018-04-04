package core_Java;
//Kevin Rivera - Revature
//Assignment Week 1: Core Java - Problem 3.
//This program compares to boolean variables in certain conditions to determine if the output.

public class Prob_3 {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean output;
		
		output = !a;
		System.out.println("Output is: " + output);
		
		output = a | b;
		System.out.println("Output is: " + output);
		
		output = (!a & b) | (a & !b);
		System.out.println("Output is: " + output);
	}
}
