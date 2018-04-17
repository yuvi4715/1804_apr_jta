package com.revature.oop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Defenders {

	DareDevil d1;
	GiftedPeople gf;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("====this will run before test method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this will run after test method====");
	}

	@Test
	@Ignore
	public void tryToCalmMurdock() {
		d1 = new DareDevil();
		assertTrue(d1.demons(""));
	}
	
	@Test
	public void checkArmorColor() {
		gf = new DareDevil();
		System.out.println("color of the armor : " + gf.armor);
		gf = new GiftedPeople();
		System.out.println("color of the armor : " + gf.armor);
	}
	
	

}
