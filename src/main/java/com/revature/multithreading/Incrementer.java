package com.revature.multithreading;

public class Incrementer {
	public static int i = 0;
	
	public synchronized int incrementer() {
		return ++i;
	}
}
