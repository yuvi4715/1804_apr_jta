package com.revature.Homework.ProblemFourteen;

import java.io.PrintStream;

public class ProblemFourteen {

	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		try {
			out.println("Top of the morning to you");
		} catch(Exception e)
		{
			
		} finally
		{
			out.println("Good bye !");
		}
	}

}
