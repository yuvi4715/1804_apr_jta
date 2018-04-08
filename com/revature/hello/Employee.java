package com.revature.hello;



public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	private String role;
	int age;
	String name;
	int dept;

	public Employee(int employeeID, String firstName, String lastName, String role) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	public Employee(String name, int dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	public String toString() {
		return "employeeID: " + employeeID + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nrole: "
				+ role;
	}
}