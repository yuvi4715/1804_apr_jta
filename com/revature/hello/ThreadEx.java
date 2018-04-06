package com.revature.hello;

public class ThreadEx extends Thread {

	public void run() {
		System.out.println("Hello from a thread!");
	}

	public static void main(String args[]) {
		Thread t = new ThreadEx();
		t.start();
	}
}