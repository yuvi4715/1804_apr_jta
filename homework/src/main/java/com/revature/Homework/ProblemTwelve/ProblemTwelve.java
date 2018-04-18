package com.revature.Homework.ProblemTwelve;

import java.io.PrintStream;

public class ProblemTwelve  {
	public static void main(String... strings ) 
	{
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		try {
			out.println("Starting try block");
			throw new ProblemTwelveException();
		}catch(Exception e) {
			out.println("Starting catch block");
		} finally {
			out.println("Starting finally block");
		}
	}
}
