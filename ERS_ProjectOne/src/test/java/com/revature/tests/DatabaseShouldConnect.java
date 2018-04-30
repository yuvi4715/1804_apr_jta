package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.util.ConnectionUtil;

public class DatabaseShouldConnect {

	@Test
	public void testGetConnection() {
		assertTrue("Connection fail", ConnectionUtil.getConnection() != null);
	}
}
