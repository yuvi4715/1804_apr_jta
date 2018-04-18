package com.revature.projectzero.accounts;

public enum AccountTypes {
	savings04092018(10),checkings04092018(3);
	
	private int interestRate;

	private AccountTypes(int interestRate) {
		this.interestRate = interestRate;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	
}
