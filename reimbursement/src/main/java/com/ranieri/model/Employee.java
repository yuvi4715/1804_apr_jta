package com.ranieri.model;

public class Employee {
	
	String email;
	String password;
	int authorization;

	
	public Employee() {
		
	}
	
	public Employee(String email, String password, int authorization) {
		super();
		this.email = email;
		this.password = password;
		this.authorization = authorization;
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getAuthorization() {
		return authorization;
	}



	public void setAuthorization(int authorization) {
		this.authorization = authorization;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", password=" + password + ", authorization=" + authorization + "]";
	}

	

}
