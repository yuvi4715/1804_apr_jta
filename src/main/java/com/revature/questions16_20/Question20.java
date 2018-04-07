package com.revature.questions16_20;

public class Question20 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		System.out.println(rt.freeMemory());
		
		System.out.println(rt.totalMemory());
		
		System.out.println(rt.availableProcessors());
		
		//One example of how I would use these types of calls to run a code 
		//in different ways based on the available resources, such as 
		//designing a program to run on more threads if more cores are available.
		
		float mem = rt.totalMemory();
		
		mem = mem / 1024;
		
		System.out.println(mem + "KB");
		
		mem = mem / 1024;
		
		System.out.println(mem + "MB");
		
		mem = mem / 1024;
		
		System.out.println(mem + "GB");
	}
	
}
