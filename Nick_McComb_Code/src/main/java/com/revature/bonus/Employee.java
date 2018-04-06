package com.revature.bonus;

public class Employee {
	private int id;
	private String firstName, lastName, role;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + "]";
	}

	public boolean equals(Employee e) {
		return (this.getId() == e.getId() && this.getFirstName().equals(e.getFirstName()) && 
				this.getLastName().equals(e.getLastName()) && this.getRole().equals(e.getRole())); 
		}
	
	public int hashCode()
	{
		return this.getId();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
}
