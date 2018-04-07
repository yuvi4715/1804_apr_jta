package com.revature.test;

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
	DareDevil d1=new DareDevil();
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
	

	@Test (timeout=10) //timeout in 10milliseconds
	@Ignore
	public void tryToCalmMurdock() {
		
		boolean calm=d1.demons("goldstick");
		assertFalse(!calm); //fail if calm is true, 
		//or asserTrue(d1.demons("gold stick"));
		//fail("Not yet implemented");
		System.out.println("from the test1() method");
	}
	
	@Test
	public void checkArmorColor() {
		//fields not inherited
		gf=new DareDevil(); //inheritance, dareDevil is child of GiftedPeople
		System.out.println("color of armor " + gf.armor);
		GiftedPeople gf2=new GiftedPeople();
		System.out.println("color of armor " + gf2.armor);
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
		new IronFist(true, "Danny danny");
	}
}
