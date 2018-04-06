package com.revature.oop;

public class WellFargo {
	
	public static void main(String[] args) {
		Bank wellsFargo = new Bank();
		wellsFargo.setAccountBalance(1000);
		wellsFargo.setAccountName("Tom");
		wellsFargo.setAccountNumber(123456789);
		wellsFargo.setAccountType("Checking");
		
		System.out.println(wellsFargo.getAccountName() + " has accout type of " +
		 wellsFargo.getAccountType() + " with account balance of " + 
				wellsFargo.getAccountBalance()+
				" in his account " + 
				wellsFargo.getAccountNumber());
		
	}

}
