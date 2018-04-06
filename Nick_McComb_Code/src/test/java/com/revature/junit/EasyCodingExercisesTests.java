package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.EasyCodingExercises.MethodsECE;

public class EasyCodingExercisesTests {
	MethodsECE m = new MethodsECE();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void PassFailTest() {
		assertTrue(m.CheckPassFail(50));
		assertTrue(m.CheckPassFail(99));
		assertFalse(m.CheckPassFail(2));
	}

}
