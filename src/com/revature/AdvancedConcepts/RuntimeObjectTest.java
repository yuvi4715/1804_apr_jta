package com.revature.AdvancedConcepts;


public class RuntimeObjectTest {
//problem 21
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.availableProcessors());
		System.out.println(rt.maxMemory());
		System.out.println(rt.freeMemory());
	}
}
