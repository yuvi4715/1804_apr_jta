package com.revature.multithreading;

public class ThreadApp {

	public static void main(String[] args) {
		ThreadOne t1 = new ThreadOne("Andy");
		t1.start();
		
		ThreadOne t2 = new ThreadOne("Dakota");
		t2.start();
		
		ThreadOne t3 = new ThreadOne("Mitch");
		t3.start();
		
		
//		ThreadTwo t2 = new ThreadTwo();
//		t2.start();
	}

}
