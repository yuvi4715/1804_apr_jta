package com.revature.multithreading;

public class TestThreadNoSync {

	public static void main(String[] args) {
		RunnableDemoNoSync R1 = new RunnableDemoNoSync("Thread-1");
		R1.start();

		RunnableDemoNoSync R2 = new RunnableDemoNoSync("Thread-2");
		R2.start();
		
		RunnableDemoNoSync R3 = new RunnableDemoNoSync("Thread-3");
		R3.start();
	}

}
