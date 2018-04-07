package com.revature.thread;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestThreads {

	public static void main(String[] args) {
	/*	//runs concurrently
		ExtendsThread t1= new ExtendsThread("one");
		t1.start();
		ExtendsThread t2= new ExtendsThread("two");
		t2.start();*/
		
		Thread a1= new Thread(new ImplementsRunnable());
		a1.start();
		Thread a2= new Thread(new ImplementsRunnable());
		a2.start();
		ImplementsRunnable a=new ImplementsRunnable();
		new Thread(a).start();
		/*
		try {
			t1.join(); //mean wait for thread to die
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
