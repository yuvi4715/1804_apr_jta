package com.revature.Homework.ProblemFive;

import java.io.PrintStream;

public class ProblemFiveMain {
	public static void main(String[] args) {
		test01(System.out);
	}

	public static void test01(PrintStream out) {
		ProblemFive math = new ProblemFive();
		out.println(math.add(1f, 2f));
		out.println(math.substract(1f, 2f));
		out.println(math.multiply(1f, 2f));
		out.println(math.divide(1f, 2f));
	}
}
