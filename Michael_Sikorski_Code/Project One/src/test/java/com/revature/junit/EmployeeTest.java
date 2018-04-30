/*
 *	Author: Michael Sikorski
 *	Date: 4/29/2018
 *
 *	Project One - Reimbursement Request System
 */

package com.revature.junit;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;

// Test class for Employee objects
public class EmployeeTest {

	@Test
	public void validateEmployeeInformation() {
		Employee e = EmployeeService.getEmployeeService().getEmployee("testEmployee");
		Assert.assertEquals("testEmployee", e.getEmail());
		Assert.assertEquals("testEmployee", e.getUsername());
		Assert.assertEquals("testFirst", e.getFirstName());
		Assert.assertEquals("testLast", e.getLastName());
	}
	
	@Test
	public void doesEmployeeUpdateMethodActuallyUpdate() {
		Employee beforeUpdate = EmployeeService.getEmployeeService().getEmployee("testEmployee");
		Assert.assertEquals("testEmployee", beforeUpdate.getEmail());
		Assert.assertEquals("testEmployee", beforeUpdate.getUsername());
		Assert.assertEquals("testFirst", beforeUpdate.getFirstName());
		Assert.assertEquals("testLast", beforeUpdate.getLastName());
		boolean updatedBefore = EmployeeService.getEmployeeService().updateEmployee("testEmployee", "updatedTestEmployee", "updatedTestFirst", "updatedTestLast");
		Assert.assertEquals(true, updatedBefore);
		Employee afterUpdate = EmployeeService.getEmployeeService().getEmployee("testEmployee");
		Assert.assertEquals("testEmployee", afterUpdate.getEmail());
		Assert.assertEquals("updatedTestEmployee", afterUpdate.getUsername());
		Assert.assertEquals("updatedTestFirst", afterUpdate.getFirstName());
		Assert.assertEquals("updatedTestLast", afterUpdate.getLastName());
		boolean updatedAfter = EmployeeService.getEmployeeService().updateEmployee("testEmployee", "testEmployee", "testFirst", "testLast");
		Assert.assertEquals(true, updatedAfter);
	}
	
	@Test
	public void doesEmployeeCreationWork() {
		String email = "employee" + Calendar.getInstance().getTimeInMillis();
		boolean success = EmployeeService.getEmployeeService().createNewEmployee(email, "testEmployeeCreation", "testEmployeeCreation", "testEmployeeCreation", "testEmployeeCreation");
		Assert.assertEquals(true, success);
	}

}
