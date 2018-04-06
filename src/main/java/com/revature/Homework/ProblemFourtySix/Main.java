package com.revature.Homework.ProblemFourtySix;

import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		int  a=9,b=10;
		out.println(a+" "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		out.println(a+" "+b);
	}
}
