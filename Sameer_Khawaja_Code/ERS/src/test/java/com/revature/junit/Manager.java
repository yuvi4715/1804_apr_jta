package com.revature.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;


import com.revature.util.ConnectionUtil;



class Manager {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	
	public void testDBConnection() {
		assertTrue("Connection fail", ConnectionUtil.getConnection() != null);
}
	
}
