package com.revature.Homework.ProblemFour;

import java.io.PrintStream;

public class ProblemFour {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		ProblemFour math = new ProblemFour();
		out.println(math.add(1f, 2f));
		out.println(math.substract(1f, 2f));
		out.println(math.multiply(1f, 2f));
		out.println(math.divide(1f, 2f));
	}
	public float add(float a, float b) {
		return a+b;
	}
	public float substract(float a, float b) {
		return a-b;
	}
	public float multiply(float a, float b) {
		return a*b;
	}
	public float divide(float a, float b) {
		return  a/b;
	}
}
