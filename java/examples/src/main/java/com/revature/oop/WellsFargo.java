package com.revature.oop;

public class WellsFargo {

	public static void main(String[] args) {
		Bank wellsFargo = new Bank();
		wellsFargo.setAccountBalance(1000);
		wellsFargo.setAccountName("Tom");
		wellsFargo.setAccountNumber(1234567890);
		wellsFargo.setAccountType("Checking");
		
		System.out.println(wellsFargo.getAccountName() + " has account type of "
					+ wellsFargo.getAccountType()
					+ " with account balance of "
					+ wellsFargo.getAccountBalance()
					+ " in his account " 
					+ wellsFargo.getAccountNumber());
	}

}
