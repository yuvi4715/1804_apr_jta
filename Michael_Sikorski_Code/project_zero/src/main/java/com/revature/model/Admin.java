package com.revature.model;

public class Admin extends User {
	
	//boolean isAdmin;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Admin(String username, boolean admin, String email) {
		super(username, true, email);
	}

}
