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

import com.revature.model.Manager;
import com.revature.service.ManagerService;

// Test class for Manager objects
public class ManagerTest {

	@Test
	public void validateManagerInformation() {
		Manager m = ManagerService.getManagerService().getManager("testManager");
		Assert.assertEquals("testManager", m.getEmail());
		Assert.assertEquals("testManager", m.getUsername());
		Assert.assertEquals("managerFirst", m.getFirstName());
		Assert.assertEquals("managerLast", m.getLastName());
	}

	@Test
	public void doesManagerCreationWork() {
		String email = "manager" + Calendar.getInstance().getTimeInMillis();
		boolean success = ManagerService.getManagerService().createNewManager(email, "testManagerCreation",
				"testManagerCreation", "testManagerCreation", "testManagerCreation");
		Assert.assertEquals(true, success);
	}

}
