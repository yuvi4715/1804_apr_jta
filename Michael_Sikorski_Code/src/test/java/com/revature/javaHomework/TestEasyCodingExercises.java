package com.revature.javaHomework;

import org.junit.Test;
import org.junit.Assert;

import easy_coding_exercises.*;

public class TestEasyCodingExercises {

	@Test
	public void testQuestion32() {
		Assert.assertEquals("FAIL", CheckPassFail.result(20));
		Assert.assertEquals("PASS", CheckPassFail.result(70));
		Assert.assertEquals("PASS", CheckPassFail.result(50));
	}
	
	@Test
	public void testQuestion33() {
		Assert.assertEquals("Even Number", CheckOddEven.OddOrEven(0));
		Assert.assertEquals("Odd Number", CheckOddEven.OddOrEven(1));
		Assert.assertEquals("Even Number", CheckOddEven.OddOrEven(2));
		Assert.assertEquals("Odd Number", CheckOddEven.OddOrEven(3));
	}
	
	@Test
	public void testQuestion34() {
		Assert.assertEquals("OTHER", PrintNumberInWord.printNumberInWordA(0));
		Assert.assertEquals("ONE", PrintNumberInWord.printNumberInWordB(1));
		Assert.assertEquals("TWO", PrintNumberInWord.printNumberInWordA(2));
		Assert.assertEquals("THREE", PrintNumberInWord.printNumberInWordB(3));
		Assert.assertEquals("FOUR", PrintNumberInWord.printNumberInWordA(4));
		Assert.assertEquals("FIVE", PrintNumberInWord.printNumberInWordB(5));
		Assert.assertEquals("SIX", PrintNumberInWord.printNumberInWordA(6));
		Assert.assertEquals("SEVEN", PrintNumberInWord.printNumberInWordB(7));
		Assert.assertEquals("EIGHT", PrintNumberInWord.printNumberInWordA(8));
		Assert.assertEquals("NINE", PrintNumberInWord.printNumberInWordB(9));
		Assert.assertEquals("OTHER", PrintNumberInWord.printNumberInWordA(10));
	}
	
	@Test
	public void testQuestion35() {
		KeyboardScanner ks = new KeyboardScanner();
		String[] args = {};
		ks.main(args);
	}
	
	@Test
	public void testQuestion36() {
		String[] args1 = {};
		Arithmetic.main(args1);
	}

	@Test
	public void testQuestion37() {
		GradesStatistics gs = new GradesStatistics();
		String[] args = {};
		gs.main(args);
	}
}
