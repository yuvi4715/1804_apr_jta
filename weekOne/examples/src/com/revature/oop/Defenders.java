package com.revature.oop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Defenders {
	
	DareDevil d1;
	GiftedPeople gf;
	JessicaJones jj;

	@Before
	public void setUp() throws Exception {
		System.out.println("This will run before test method");
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void tryToCalmMurkock() {
		 d1 = new DareDevil();
		assertTrue(d1.demons("Blind Stick"));
		//fail("Not yet implemented");
	}
	@Test
	public void checkArmorColor() {
		gf = new GiftedPeople();
		System.out.println("color of the armor: " +  gf.armor);
		gf = new DareDevil();
		System.out.println("color of the armor: " + gf.armor);
	}
	@Test
	public void checkIfJessicaHasAFriend() {
		jj = new JessicaJones();
		jj.friends(null);
		jj.friends("Trish");
		jj.friends("Trish", "Luke");
	}

}
