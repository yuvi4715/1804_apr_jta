package coreJava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCoreBlock {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Problem1 p1 = new Problem1();
		System.out.println(p1.addFunction());
		System.out.println(p1.subtractFunction());
		System.out.println(p1.multiplyFunction());
		System.out.println(p1.divideFunction());
		
	}
	
	@Test
	public void test2() {
		
		int a = 3;
		int b = 123;
		int c = 15;
		
		Problem2 p2 = new Problem2();
		System.out.println(p2.greatestOfThree(a, b, c));

		
	}
	
	@Test
	public void test3() {
		Problem3 p3 = new Problem3();
		p3.outputFuction();
		
	}

}
