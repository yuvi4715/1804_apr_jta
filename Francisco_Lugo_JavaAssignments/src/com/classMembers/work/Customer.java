package com.classMembers.work;

public class Customer {
	
	public static final String storeName = "Walmart";
	public int custNumber;
	public String name;
	
	public Customer() {
		this.setCustInfo(35,"Tom");
		System.out.println("Name: " + name + "   Customer Number: " + custNumber);
		System.out.println("Customer of " + storeName);
	}
	public Customer(int custNumber) {
		this.setCustInfo("Bob", custNumber);
		System.out.println("Name: " + name + "   Customer Number: " + custNumber);
		System.out.println("Customer of " + storeName);
	}

	public void setCustInfo(int num, String str) {
		custNumber = num;
		name = str;
	}
	
	public void setCustInfo(String str, int num) {
		custNumber = num;
		name = str;
	}
	
	public static void isCustomer() {
		System.out.println("This is a customer");
	}
	public static void hasNumber() {
		System.out.println("This customer has a number");
	}
}
