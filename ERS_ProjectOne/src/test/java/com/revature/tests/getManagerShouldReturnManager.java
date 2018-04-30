package com.revature.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoJdbc;

public class getManagerShouldReturnManager {

	@Test
	public void testGetManager() {
		ManagerDao md = new ManagerDaoJdbc();
		assertTrue("No manager returned", md.getManager("username", "password") != null);
	}
}
