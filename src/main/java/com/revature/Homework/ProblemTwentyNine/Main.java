package com.revature.Homework.ProblemTwentyNine;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		MyThread thread1=new MyThread(main);
		MyThread thread2=new MyThread(main);
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		t1.start();
		t2.start();
		System.out.println(thread1.getValue());
		System.out.println(thread2.getValue());
	}
	
	private int i=0;
	
	public int increment() {
		return ++i;
	}
	
	
}