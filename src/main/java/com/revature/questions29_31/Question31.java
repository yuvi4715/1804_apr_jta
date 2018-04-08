package com.revature.questions29_31;

import java.util.ArrayList;
import java.util.List;

public class Question31 {

	public static void main(String[] args) {
	
		imGreatAtThreading3 t1 = new imGreatAtThreading3("Good Guy");
		imGreatAtThreading3 t2 = new imGreatAtThreading3("Bad Guy");
		imGreatAtThreading3 t3 = new imGreatAtThreading3("Okay Guy");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	
	
}

class imGreatAtThreading3 implements Runnable {

	private Thread t;
	private String name;
	int sumNum;
	List<Integer> numList = new ArrayList<>();

	public imGreatAtThreading3(String name) {
		this.name = name;
		this.sumNum = 0;
	}
	
	public synchronized void start() {
		t = new Thread(this, name);
		t.start();
	}
	
	@Override
	public void run() {

		try {
			for (int i = 0; i < 1000; i++) {
				numList.add(++sumNum);
				Thread.sleep(10);
			}
			actionPrint();

		} catch (InterruptedException e) {
			System.out.println(name + " failure at " + sumNum);
		}

	}

	public void actionPrint() {
		for (Integer i : numList) {
			System.out.println(name + " printing: " + i.intValue());
		}
	}

}
