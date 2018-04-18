package com.revature.model;

public class Client extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Client(String username, boolean admin, String email) {
		super(username, false, email);
	}

}
