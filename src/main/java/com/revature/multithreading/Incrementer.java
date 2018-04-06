package com.revature.multithreading;

// Question 29
public class Incrementer {
	public static int i = 0;
	
	// Question 30
	public synchronized int incrementer() {
		return ++i;
	}
}
