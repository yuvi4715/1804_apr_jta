package com.revature.Homework.ProblemThirty;


public class  MyThread implements Runnable{
	Main main;
	int value;
	public MyThread(Main pMain) {
		main=pMain;
	}
	public void run() {
		for(int i=0;i<1000;i++)
		value=main.increment();
	}
	public int getValue() {
		return value;
	}

}
