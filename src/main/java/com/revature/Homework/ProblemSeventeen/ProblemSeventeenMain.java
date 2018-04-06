package com.revature.Homework.ProblemSeventeen;


import java.io.PrintStream;
import java.util.StringTokenizer;

public class ProblemSeventeenMain {

	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		String s = "pickles:ketchup:mustard:onion" ;
		StringTokenizer tokenizer = new StringTokenizer(s, ":");
		while(tokenizer.hasMoreTokens())
			out.println(tokenizer.nextToken());
	}

}
