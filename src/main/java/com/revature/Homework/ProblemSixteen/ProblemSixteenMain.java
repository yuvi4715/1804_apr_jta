package com.revature.Homework.ProblemSixteen;

import java.io.PrintStream;

public class ProblemSixteenMain {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out){
		String a = "String";
		StringBuilder ba = new StringBuilder(a);
		ba.append(" Hello World");
		ba.deleteCharAt(11);
		ba.setLength(12);
		out.println(ba.toString());
	}
}
