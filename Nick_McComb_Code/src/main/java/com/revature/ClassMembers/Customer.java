package com.revature.ClassMembers;

public class Customer {
	
	static String species = "Human";
	final boolean alive = true;
	private String name;
	
	public Customer() {
		this.name = "Unknown";
	}
	
	public Customer(String name) {
		this.name = name;
	}
	
	void askName() {
		System.out.println("My name is " + name);
	}
	
	void askName(int age) {
		System.out.println("My name is " + name + " and I am " + age + " years old.");
	}
	
	static void species() {
		System.out.println("This customer is a " + species);
	}
	
	void isAlive() {
		System.out.println("Am I alive? " + alive);
	}
}
