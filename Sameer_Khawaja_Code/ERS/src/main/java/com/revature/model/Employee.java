package com.revature.model;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1152854560029872120L;

	public Employee() {
		
	}
	
	public Employee(int id, String first_name, String last_name, String email, String username, String password) {
		super(id, first_name, last_name, email, username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getFirst_name() {
		// TODO Auto-generated method stub
		return super.getFirst_name();
	}

	@Override
	public void setFirst_name(String first_name) {
		// TODO Auto-generated method stub
		super.setFirst_name(first_name);
	}

	@Override
	public String getLast_name() {
		// TODO Auto-generated method stub
		return super.getLast_name();
	}

	@Override
	public void setLast_name(String last_name) {
		// TODO Auto-generated method stub
		super.setLast_name(last_name);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
