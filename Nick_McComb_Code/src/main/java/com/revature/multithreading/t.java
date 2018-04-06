package com.revature.multithreading;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class t extends Thread{
	public int i;
	
	public synchronized void run() {
		Set<Integer> is = new HashSet();
		for(int r = 0; r < 1000; r++) {
			i++;
			is.add(i);
		}
		System.out.println(Arrays.toString(is.toArray()));
	}
	
	public synchronized void start() {
		super.start();
		run();
	}
}
