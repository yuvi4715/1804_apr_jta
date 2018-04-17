package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.oop.DareDevil;
import com.revature.oop.GiftedPeople;
import com.revature.oop.IronFist;
import com.revature.oop.JessicaJones;

public class Defenders {

	DareDevil d1;
	GiftedPeople gf;
	JessicaJones jj;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("====this will run before test method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("this will run after test method====");
	}

	@Test (timeout=10)
	//@Ignore
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
	
	@Test
	public void checkIfJessicaHasAFriend() {
		jj = new JessicaJones();
		jj.friends(null);
		jj.friends("Trish");
		jj.friends("Trish","Luke");
	}
	
	@Test 
	public void getNameOfIronFist() {
		new IronFist();
		new IronFist(true);
		new IronFist(true, "Danny Rand");
	}

}
