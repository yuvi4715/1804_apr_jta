package com.multithreading.work;

public class threadMain {

	public static void main(String[] args) {
		ThreadBlueprint tb1 = new ThreadBlueprint("Thread 1");
		ThreadBlueprint tb2 = new ThreadBlueprint("Thread 2");
		ThreadBlueprint tb3 = new ThreadBlueprint("Thread 3");
		
		tb1.start();
		tb2.start();
		tb3.start();

	}

}
