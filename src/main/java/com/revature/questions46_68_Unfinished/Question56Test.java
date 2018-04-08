package com.revature.questions46_68_Unfinished;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Question56Test extends Question56 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void noModulusTest() {
		evenOrOdd(11);
		evenOrOdd(111);
		evenOrOdd(122);
		evenOrOdd(123);
		evenOrOdd(1000);
		evenOrOdd(1001);
		evenOrOdd(0);
		evenOrOdd(-2);
		evenOrOdd(200);
		evenOrOdd(201);
		
	}
	@Test
	public void ModulusTest() {
		evenOrOddMod(11);
		evenOrOddMod(111);
		evenOrOddMod(122);
		evenOrOddMod(123);
		evenOrOddMod(1000);
		evenOrOddMod(1001);
		evenOrOddMod(0);
		evenOrOddMod(-2);
		evenOrOddMod(200);
		evenOrOddMod(201);
	}

}
