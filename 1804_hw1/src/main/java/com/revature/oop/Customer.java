package com.revature.oop;

public class Customer {

	private static int customerCount = 0;
	private static final int STORE_NUMBER = 123456;
	private double balance;
	private String name;
	private String email;
	
	// 1st Constructor
	public Customer() {
		name = "";
		email = "";
		balance = 0;
		customerCount++;
	}
	
	// 2nd Constructor
	public Customer(String name, String email, double balance) {
		this.name = name;
		this.email = email;
		this.balance = balance;
		customerCount++;
	}
	
	// 1st overloaded method
	public void payBalance() {
		balance = 0;
	}
	
	// 2nd overloaded method
	public void payBalance(double amount) {
		balance -= amount;
	}
	
	public static int getStoreNumber() {
		return STORE_NUMBER;
	}

	public static int getCustomerCount() {
		return customerCount;
	}

	public static void setCustomerCount(int customerCount) {
		Customer.customerCount = customerCount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
