package com.revature.Homework.ProblemEighteen;

import java.io.PrintStream;

public class ProblemEighteenMain {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out){
		String a="20",b="45";
		int aInt=Integer.parseInt(a);
		int bInt=Integer.parseInt(b);
		out.println("Totals : "+(aInt+bInt));
	}
}
