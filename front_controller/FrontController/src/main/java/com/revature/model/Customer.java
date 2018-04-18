package com.revature.model;

/* Main Customer POJO (bean) needed for example */
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public Customer() {
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
	}

	public Customer(int id) {
		this();
		this.id = id;
	}
	
	public Customer(String username) {
		this();
		this.username = username;
	}
	
	public Customer(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}
	
	public Customer(int id, String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + "]";
	}
}
