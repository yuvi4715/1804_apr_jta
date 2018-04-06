package com.revature.classmembers;

public class Customer {
	/*
	 * 7. Create a Customer class with: a. At least 2 constructors b. At least 2
	 * overloaded methods c. At least 1 static variable d. At least 2 static methods
	 * e. At least 1 final variable
	 */
	int money;
	static String gender;
	final String name;

	public Customer(String name, String gender) {
		super();
		this.name = name;
		Customer.gender = gender;
	}

	public Customer(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

	public static void Mood() {
		System.out.println("Customers are not feeling well!");
	}
	
	public static void askPrice() {
		System.out.println("How much for the product?");
	}
	
	public void GrabItem() {
		System.out.println("Item is acquired!");
	}
	
	public void GrabItem(int numberOfItems) {
		System.out.println("You acquired " + numberOfItems + " items.");
	}
	
	public void Deposit() {
		System.out.println("You deposited some money!");
	}
	
	public void Deposit(int DepositedMoney) {
		System.out.println("You deposited " + DepositedMoney + "$ into your bank!");
	}

}
