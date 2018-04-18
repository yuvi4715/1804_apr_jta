package com.revature.model;

import java.io.Serializable;

public class BankAccount implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3376103777903504148L;
	private int accountType;
	private int holder;
	private double balance;
	
	public BankAccount(int accountType, int holder, double balance) {
		super();
		this.accountType = accountType;
		this.holder = holder;
		this.balance = balance;
	} 
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public int getHolder() {
		return holder;
	}
	public void setHolder(int holder) {
		this.holder = holder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	@Override
	public String toString() {
		String str;
		int temp = accountType%10;
		
		switch(temp) {
		case(1):
			str = new String("Checking");
			break;
		case(8):
			str = new String("Savings");
			break;
		default:
			str = new String("Unknown");
		}
		return "BankAccount [Account Type: " + str + ", Account Number=" + holder + "-" + accountType + ", Balance: " + balance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountType;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + holder;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountType != other.accountType)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (holder != other.holder)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
