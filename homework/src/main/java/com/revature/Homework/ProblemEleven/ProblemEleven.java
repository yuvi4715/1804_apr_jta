package com.revature.Homework.ProblemEleven;

import java.io.PrintStream;

public class ProblemEleven  {
	public static void main(String... strings ) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		try {
			throw new ProblemElevenException();
		}catch(Exception e) {
			out.println(e.getMessage());
		}
	}
}
