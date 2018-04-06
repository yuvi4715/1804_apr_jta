package com.revature.Homework.ProblemNine;

import java.io.PrintStream;

public class Human extends Mammal {

	@Override
	public void eat(PrintStream out) {
		out.println("Human eating");
	}
	public void move(PrintStream out) {
		out.println("Moving");
	}

}
