package com.revature.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;

public class getAllEmployeeShouldReturnEmployeeList {

	@Test
	public void testGetAllEmployee() {
		EmployeeDao ed = new EmployeeDaoJdbc();
		List<Employee> testList = new ArrayList<>();
		testList = ed.getAllEmployee();
		assertTrue("No employees returned", testList != null);
	}

}
