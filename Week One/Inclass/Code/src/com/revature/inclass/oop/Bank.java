package com.revature.inclass.oop;

public class Bank {
	private int accountNumber;
	float accoountBalance;
	private String accountName;
	private String accountType;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getAccoountBalance() {
		return accoountBalance;
	}

	public void setAccoountBalance(float accoountBalance) {
		this.accoountBalance = accoountBalance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(int accountNumber, float accoountBalance, String accountName, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accoountBalance = accoountBalance;
		this.accountName = accountName;
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Bank [accountNumber=" + accountNumber + ", accoountBalance=" + accoountBalance + ", accountName="
				+ accountName + ", accountType=" + accountType + "]";
	}

}
