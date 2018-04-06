package com.revature.Homework.ProblemFourtyNine;

import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		String s = "Hello World!";
		out.println(substring(s, 1, 5));
		out.println(s.substring(1,5));
		out.println(substring(s, 1));
		out.println(s.substring(1));
	}
	public static String substring(String s, int startLocation,int endLocation)
	{
		String result = "";
		for(int i=startLocation;i<endLocation;i++) {
			result+=s.charAt(i);
		}
		return result;
	}
	public static String substring(String s, int startLocation)
	{
		return substring(s, startLocation,s.length());
	}
}
