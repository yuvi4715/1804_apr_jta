package com.revature.classmembers;

public class Customer {
		
	private String firstName;
	private String lastName;
	
	private final boolean isCustomer = true;
	
	static int customerCount = 0;
	static int emptyCustomerCount = 0;
	
	public Customer() {
		customerCount++;
		emptyCustomerCount++;
	};
	
	public Customer(String firstName, String lastName) {
		customerCount++;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String greeting() {
		return "Hello, how are you?";
	}
	
	public String greeting(String name) {
		return "Hello, " + name + " how are you?";
	}
	
	public int getCustomerCount() {
		return customerCount;
	}
	
	public int getCustomerCount(boolean shouldPrintCustomerCount) {
		if (shouldPrintCustomerCount) {
			System.out.println("The Customer Count: " + customerCount);
		}
		return customerCount;
	}
	
	public static Customer makeEmptyCustomer() {
		Customer theCustomer = new Customer();
		return theCustomer;
	}
	
	public static int numberOfNonEmptyCustomers() {
		return customerCount - emptyCustomerCount;
	}
}
