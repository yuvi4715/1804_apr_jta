package com.revature.questions29_31;

import java.util.ArrayList;
import java.util.List;

public class Question30 {

	public static void main(String[] args) {
		
		imGreatAtThreading2 t1 = new imGreatAtThreading2("Good Guy");
		imGreatAtThreading2 t2 = new imGreatAtThreading2("Bad Guy");
		imGreatAtThreading2 t3 = new imGreatAtThreading2("Okay Guy");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	
	
}

class imGreatAtThreading2 implements Runnable {

	private Thread t;
	private String name;
	int sumNum;
	List<Integer> numList = new ArrayList<>();

	public imGreatAtThreading2(String name) {
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
