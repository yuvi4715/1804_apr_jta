package com.revature.problems1to9;
//problem 7

class Customer {
	// 2 constructors,Customer(string s, int age), Customer()
	// 1 static variable, luckyCustomerCounter
	// 2 static methods incCustomerCounter, setCutomerCounter
	// 1 final variable, customerNumber
	// 2 overloaded methods, greet(), greet(string s)
	
	
	
	
	final int customerNumber;
	static int luckyCustomerCounter;
	
	// demographic
	private String name;
	private int age;
	
	

	// constructor
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		customerNumber = luckyCustomerCounter;
	}

	// default constructor
	public Customer() {
		name = "";
		age = -1;
		customerNumber = luckyCustomerCounter;
	}
	

	public void greet() {
		System.out.println("Hello!");
	}
	
	public void greet(String name) {
		System.out.println("Hello " + name + "!");
	}
	
	
	//2 static methods
	public static void incLuckyCustomer() {
		luckyCustomerCounter++;
	}
	
	public static void setCustomerCounter(int todaysCustomerCounter) {
		luckyCustomerCounter = todaysCustomerCounter;
	}

	
	
	
	
	//getter/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	

	
	
}
