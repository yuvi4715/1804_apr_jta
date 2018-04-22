package com.revature.BankApplication;

import java.util.Date;

public class Transaction {
	
	private long id;
	private Date transactionDateTime;
	private String type;
	private double amount;
	static private long transactionCounter = 12345000;

			
	public Transaction(String type, double amount) {
			id = ++transactionCounter;
			transactionDateTime = new Date();
			this.type=type;
			this.amount = amount;
			
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime() {
		this.transactionDateTime = new Date();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}


}
