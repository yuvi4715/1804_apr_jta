package com.revature.multithreading;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Threading {

	
	public static void main(String[] args) {
		Thread t1 = new t();
		Thread t2 = new t();
		Thread t3 = new t();
		
		t1.start();
		t2.start();
		t3.start();
	}
}
