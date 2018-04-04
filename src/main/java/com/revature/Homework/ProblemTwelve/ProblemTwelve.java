package com.revature.Homework.ProblemTwelve;


public class ProblemTwelve  {
	public static void main(String... strings ) {
		try {
			System.out.println("Starting try block");
			throw new ProblemTwelveException();
		}catch(Exception e) {
			System.out.println("Starting catch block");
		} finally {
			System.out.println("Starting finally block");
		}
	}
}
