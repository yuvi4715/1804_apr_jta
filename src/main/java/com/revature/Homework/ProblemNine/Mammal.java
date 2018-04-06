package com.revature.Homework.ProblemNine;

import java.io.PrintStream;

public abstract class Mammal  implements Animal {

	public void eat(PrintStream out) {
		out.println("Eating");
	}
	
	public static void walk(PrintStream out) {
		out.println("Walking");
	}

}
