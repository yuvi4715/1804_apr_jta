package com.revature.Homework.ProblemFifteenth;

import java.io.PrintStream;

public class ProblemFifteenthMain {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		 try {
				out.println("Top of the morning to you");
				System.exit(0);
			} catch(Exception e)
			{
				
			} finally
			{
				out.println("Good bye !");
			}
	}
}
