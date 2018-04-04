
package com.revature.Homework.ProblemThirtyOne;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		MyThread thread1=new MyThread();
		MyThread thread2=new MyThread();
		MyThread thread3=new MyThread();	
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);
		t1.start();
		t2.start();
		t3.start();
		try {
			t2.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.notify();
		t2.stop();
	}
	
	
}