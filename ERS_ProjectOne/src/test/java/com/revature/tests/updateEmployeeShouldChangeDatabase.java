package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoJdbc;
import com.revature.model.Employee;

public class updateEmployeeShouldChangeDatabase {

	@Test
	public void testUpdateEmployee() {
		EmployeeDao ed = new EmployeeDaoJdbc();
		Employee testEmployee = new Employee();
		Employee updatedEmployee = new Employee();
		testEmployee = ed.getEmployee("cuong", "pass");
		testEmployee.setFirstName("test");
		ed.updateEmployee(testEmployee);
		updatedEmployee = ed.getEmployee("cuong", "pass");
		assertEquals("test", updatedEmployee.getFirstName());
	}

}
