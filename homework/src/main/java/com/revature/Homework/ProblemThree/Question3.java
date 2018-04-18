package com.revature.Homework.ProblemThree;

import java.io.PrintStream;

public class Question3 {
	public static void main(String... args)
	{
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		boolean a=true , b=false;
		out.println(!a);
		out.println(a|b);
		out.println(a^b);
	}
}