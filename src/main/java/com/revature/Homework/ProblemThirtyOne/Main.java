
package com.revature.Homework.ProblemThirtyOne;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		MyThread thread1=new MyThread();
		MyThread thread2=new MyThread();
		MyThread thread3=new MyThread();	
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		Thread t3 = new Thread(thread3);
		t1.start();
		t2.start();
		t3.start();
		
		t2.suspend();
		for(int i=0;i<100;i++);
		
		t2.resume();		
		t2.notify();
		
		t2.stop();
	}
	
	
}