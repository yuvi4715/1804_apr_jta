package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoJdbc;


public class getEmployeeShouldReturnEmployee {

	@Test
	public void testGetEmployee() {
		EmployeeDao ed = new EmployeeDaoJdbc();
		assertTrue("No employee returned", ed.getEmployee("cuong", "pass") != null);
	}
}
