package com.revature.Homework.ProblemTwentySix;


public class Employee{
	private String FirstName,LastName,Role;
	private long id;
	{
		System.out.println("Block");
	}
	//Static block is always executed
	static {
		System.out.println("static Block");
	}
	public Employee(String firstName, String lastName, String role, long id) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Role = role;
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [FirstName=" + FirstName + ", LastName=" + LastName + ", Role=" + Role + ", id=" + id
				+ "]";
	}
	
}
