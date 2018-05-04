package com.revature.model;

public class Bank {

	private int AccountBalance = 250;
	private String AccountName = "Example";
	
	public Bank(int accountBalance, String accountName) {
		super();
		AccountBalance = accountBalance;
		AccountName = accountName;
	}
	
	public int getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		AccountBalance = accountBalance;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	
	
	
}
