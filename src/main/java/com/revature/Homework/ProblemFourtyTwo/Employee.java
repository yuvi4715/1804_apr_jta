package com.revature.Homework.ProblemFourtyTwo;


public class Employee{
	private String FirstName,LastName,Role,Department;
	private long id;
	private short age=0;
	public Employee(String firstName, String lastName, String role, String department, long id, short age) {
		this(firstName, lastName, role, id);
		Department = department;
		this.age = age;
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
	
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [FirstName=" + FirstName + ", LastName=" + LastName + ", Role=" + Role + ", Department="
				+ Department + ", id=" + id + ", age=" + age + "]";
	}
	
}
