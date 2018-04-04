package com.revature.junit;

import static java.lang.System.out;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.revature.exceptions.ExceptionExample;

public class ExceptionTests {

	ExceptionExample ee;
	
	@Test
	@Ignore
	public void test() {
		ee.divideByNumbers(10, 0);
		out.println("printing with static import");
	}
	@Test (expected=NullPointerException.class)
	public void checkForNullPointer() {
		ee.pointerException();
	}
	
	@Test
	public void numberFormatException() {
		ee = new ExceptionExample();
		ee.riskyBehavior();
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	

}
