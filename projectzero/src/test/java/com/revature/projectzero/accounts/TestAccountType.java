package com.revature.projectzero.accounts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAccountType {

	@Test
	public void test() {
		AccountTypes a = AccountTypes.savings04092018;
		assertTrue(a.getInterestRate()==10);
	}
	@Test
	public void test02() {
		AccountTypes a = AccountTypes.checkings04092018;
		assertTrue(a.getInterestRate()==3);
	}
}
