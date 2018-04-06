package com.revature.classmembers;

public class UsingCustomers extends Customer {
	/*
	 * 8. Create a main method in a new class that: a. Creates 2 customers b. Uses
	 * each of the Customer class members
	 * 
	 */
	public UsingCustomers(int money, String name) {
		super(money, name);
	}

	public static void main(String[] args) {
	Customer Bob = new Customer("Bob", "Male");
	Customer Sara = new Customer(6000, "Sara");
	Bob.GrabItem();
	Customer.askPrice();
	Customer.Mood();
	Sara.GrabItem(5);
	Sara.Deposit();
	Bob.Deposit(5);
	}

}
