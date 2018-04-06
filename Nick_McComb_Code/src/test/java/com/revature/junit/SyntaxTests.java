package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.Syntax.Question5Methods;

public class SyntaxTests {
	Question5Methods q = new Question5Methods();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void ArithmeticTest() {
		assertTrue((q.add(1,4) == 5));
		assertTrue((q.subtract(10,5) == 5));
		assertTrue((q.multiply(2, 8) == 16));
		assertTrue((q.divide(2,4) == 0.5));
	}

}
