package com.revature.Homework.ProblemSixteen;


public class ProblemSixteenMain {
	public static void main(String[] args) {
		String a = "String";
		StringBuilder ba = new StringBuilder(a);
		ba.append(" Hello World");
		ba.deleteCharAt(11);
		ba.setLength(12);
		System.out.println(ba.toString());
	}
}
