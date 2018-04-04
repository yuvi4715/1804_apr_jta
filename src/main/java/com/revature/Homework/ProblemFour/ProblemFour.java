package com.revature.Homework.ProblemFour;


public class ProblemFour {
	public static void main(String[] args) {
		ProblemFour math = new ProblemFour();
		math.add(1f, 2f);
		math.substract(1f, 2f);
		math.multiply(1f, 2f);
		math.divide(1f, 2f);
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
