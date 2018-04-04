package com.revature.Homework.ProblemTwenty;


public class ProblemTwenty {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		System.out.println(runtime.totalMemory());
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.availableProcessors());
	}
}
