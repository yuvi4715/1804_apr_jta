package com.revature.model;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
	
	private String type;
	private double amount;
	private Date date;
	//private Calendar c;
	
	public Transaction(String type, double amount, Calendar c) {
		this.type = type;
		this.amount = amount;
		this.date = c.getTime();
	}
	
	public String getType() {
		return type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Date getDate() {
		return date;
	}

}
