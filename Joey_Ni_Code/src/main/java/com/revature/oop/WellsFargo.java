package com.revature.oop;

public class WellsFargo {

	public static void main(String[] args) { //bad practice to write lot of code in main
		Bank wellsFargo= new Bank();
		wellsFargo.setAccountBalance(1000);
		wellsFargo.setAccountName("MyAccount");
		wellsFargo.setAccountNumber(123456);
		wellsFargo.setAccountType("Checking");
		System.out.println(wellsFargo.getAccountName()+" has account type of " 
				+wellsFargo.getAccountType()
				+"with account balance of " +wellsFargo.getAccountBalance()
				+" in his account "
				+ wellsFargo.getAccountNumber());
	}
}
