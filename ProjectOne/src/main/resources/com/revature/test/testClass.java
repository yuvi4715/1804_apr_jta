package com.revature.test;

import com.revature.model.Request;
import com.revature.model.User;

import junit.framework.TestCase;

public class testClass extends TestCase {

	User u1 u1 = new User("kappa@gmail.com", "kappa", "ross", "kappa", "ross", "manager");
	Request r1 = new Request(4000, "test@gmail.com", "", "pending", "reasons");
	
	public testClass(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test
	public void checkPosition() {
		if (u1.getPosition() == "manager") {
			pass();
		}else {
			fail();
		}
	}
	
	@Test
	public void checkUsername() {
		if (u1.getUserName() == "kappa") {
			pass();
		}else {
			fail();
		}
	}

}
