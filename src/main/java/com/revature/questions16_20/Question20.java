package com.revature.questions16_20;

public class Question20 {

	public static void main(String[] args) {
		Runtime runthread= Runtime.getRuntime();
		
		System.out.println("Test on thread's free memory: " + runthread.freeMemory());
		
		System.out.println("Test on thread's total memory: " + runthread.totalMemory());
		
		System.out.println("Test on thread's available processors: " + runthread.availableProcessors());
		
		//I think I would use this to test the upper limits and general usage of the memory 
		//used by the JVM. Especially if I have some evilthreads(?) or something else running haywire,
		//I think I would be able to check using commands with runtime.
	}
	
}
