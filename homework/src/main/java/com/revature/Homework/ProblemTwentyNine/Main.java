package com.revature.Homework.ProblemTwentyNine;

import java.io.PrintStream;

public class Main {
	public static void main(String[] args) {
		test01(System.out);
	}
	public static void test01(PrintStream out){
		Main main = new Main();
		MyThread thread1=new MyThread(main);
		MyThread thread2=new MyThread(main);
		Thread t1 = new Thread(thread1);
		Thread t2 = new Thread(thread2);
		t1.start();
		t2.start();
		out.println(thread1.getValue());
		out.println(thread2.getValue());
	}
	private int i=0;
	
	public int increment() {
		return ++i;
	}
	
	
}