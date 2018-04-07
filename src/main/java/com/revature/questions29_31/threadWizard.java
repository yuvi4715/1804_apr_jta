package com.revature.questions29_31;

public class threadWizard{
	public static void main(String[] args) {
		
		Question29 t1 = new Question29("Thread-1");
		t1.start();

		Question29 t2 = new Question29("Thread-1");
		t2.start();
		
		Question29 t3 = new Question29("Thread-1");
		t3.start();
	}
}
