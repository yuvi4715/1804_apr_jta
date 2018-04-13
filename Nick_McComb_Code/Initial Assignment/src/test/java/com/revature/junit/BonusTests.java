package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.bonus.BonusMethods;

public class BonusTests {
	BonusMethods m = new BonusMethods();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void midTest() {
		assertTrue(m.midList().equals("Fourth"));
	}
	
	@Test
	public void factorialTest() {
		assertTrue(m.myFactorial(4) == 24);
	}
	
	@Test
	public void evenTest() {
		assertTrue(m.isEven(8));
		assertFalse(m.isEven(101));
	}
	
	@Test
	public void palindromeTest() {
		assertTrue(m.isPalindrome("racecar"));
		assertFalse(m.isPalindrome("nick"));
	}
	
	@Test
	public void swapTest() {
		m.numSwap(5, 10);
	}
	
	@Test
	public void reverseNumberTest() {
		assertTrue(m.reverseNumber(1002) == 2001);
	}
	
	@Test
	public void ratTest() {
		m.rat();
	}
	
	
	
}
