package com.iofile.work;

public class Employee {
	private String id, firstName, lastName, role;
	
	public Employee() {
		
	}
	
	public Employee(String id, String name, String last, String role){
		this.id = id;
		this.firstName = name;
		this.lastName = last;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public void getInfo() {
		System.out.println("This is: " + firstName + " " + lastName);
		System.out.println("With Id: " + id + " and Role: " + role);
	}
}
