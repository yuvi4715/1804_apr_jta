package com.revature.syntax;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArithmeticTests {

	@Before
	public void setUp() throws Exception {
		System.out.println("This will run before test method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("This will run after the test method");
	}

	@Test
	public void addTwoSuccess() {
		Arithmetic theArithmetic = new Arithmetic();
		int result = theArithmetic.addTwo(3, 5);
		assertEquals(8, result);
	}
	
	@Test
	public void test2() {
//		fail("Not yet implemented");
		System.out.println("from the test method");
	}

}
