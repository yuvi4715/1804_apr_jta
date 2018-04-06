package com.revature.Homework.ProblemTen;

import java.io.PrintStream;

public class ProblemTen  {
	public static void main(String... strings ) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		try {
			throw new ProblemTenException();
		}catch(Exception e) {
			out.println(e.getMessage());
		}
	}
}
