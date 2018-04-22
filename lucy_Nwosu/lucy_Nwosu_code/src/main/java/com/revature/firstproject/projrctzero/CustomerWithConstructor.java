package com.revature.projrctzero;

//instance variables
public class CustomerWithConstructor {
	private String customerName;
	private int customerId;
	
//Customer constructors
	public CustomerWithConstructor(String name) { //consturctor 1
	customerName = name;
	}			
	
	public CustomerWithConstructor(int id) { 	//constructor 2
	
		customerId = id;
		}			
//standard methods to retrieve the variable from the class
	
	public String getName() {
		return customerName;
	}
	
	public int getId() {
		return customerId;
	}
	
// Methods that performs calculation
	
	
}
