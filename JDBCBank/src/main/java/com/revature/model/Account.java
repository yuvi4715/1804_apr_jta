package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable
{

	private static final long serialVersionUID = -7356758073368256484L;
	
	private int userID;
	private int accountID;
	private String accountName;
	private int balance;
	
	
	public Account() {}


	public Account(int userID, int accountID, String accountName, int balance) {
		super();
		this.userID = userID;
		this.accountID = accountID;
		this.accountName = accountName;
		this.balance = balance;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + balance;
		result = prime * result + userID;
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
		Account other = (Account) obj;
		if (accountID != other.accountID)
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (balance != other.balance)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [userID: " + userID + "| accountID: " + accountID + "| Account: " + accountName + "| Balance: "
				+ balance + "]";
	}
	
	
}
