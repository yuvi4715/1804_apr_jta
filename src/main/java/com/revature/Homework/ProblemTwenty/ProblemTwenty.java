package com.revature.Homework.ProblemTwenty;

import java.io.PrintStream;

public class ProblemTwenty {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out ){
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		out.println(runtime.totalMemory());
		out.println(runtime.freeMemory());
		out.println(runtime.availableProcessors());
	}
}
