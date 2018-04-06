package com.revature.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.AdvancedCodingExercises.MethodsACE;
import com.revature.FileIO.Employee;

public class AdvancedCodingExcercisesTests {
	MethodsACE m1 = new MethodsACE();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void armstrongTest() {
		assertTrue(m1.isArmstrong(153));
	}

	@Test
	public void replacerTest() {
		assertTrue(m1.charReplacer('a', 'z', "arthur the aardvark").equals("zrthur the zzrdvzrk"));
	}
	
	@Test
	public void primeTest() {
		assertFalse(m1.isPrime(10));
		assertTrue(m1.isPrime(11));
	}
	
	@Test
	public void reverseTest() {
		assertTrue(m1.reverseString("hello").equals("olleh"));
	}
}
