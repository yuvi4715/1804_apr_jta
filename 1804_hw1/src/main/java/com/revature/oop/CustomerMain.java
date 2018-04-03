package com.revature.oop;

// Solution to hw1 problem #8

public class CustomerMain {

	public static void main(String[] args) {
		
		// Create 1st instance of customer
		Customer c1 = new Customer();
		c1.setName("Bob Johnson");
		c1.setEmail("bob.johnson@gmail.com");
		c1.setBalance(145.50);
	
		// Create 2nd customer
		Customer c2 = new Customer("Travis Berry", "trav.berry@hotmail.com", 99.95);
		
		// Call overloaded methods
		c1.payBalance();
		c2.payBalance(20.00);
		
		// Print end balance for both customers
		System.out.println(c1.getName() + "'s balance is now " + c1.getBalance());
		System.out.println(c2.getName() + "'s balance is now " + c2.getBalance());
		
		// Call static methods
		System.out.println("Store Number: " + Customer.getStoreNumber());
		System.out.println("Customer Count: " + Customer.getCustomerCount());
	}
}
