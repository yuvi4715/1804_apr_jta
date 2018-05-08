package com.revature.model;

import java.sql.Timestamp;

public class Supervisor extends Employee {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911903311198029954L;

	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supervisor(int status, String email, String passphrase) {
		super(status, email, passphrase);
		// TODO Auto-generated constructor stub
	}

	public Supervisor(int userid, String email, String fName, String lName, Timestamp hireDate, String passphrase) {
		super(userid, email, fName, lName, hireDate, passphrase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Supervisor [getUserid()=" + getUserid() + ", getEmail()=" + getEmail() + ", getfName()=" + getfName()
				+ ", getlName()=" + getlName() + ", getHireDate()=" + getHireDate()+ "]";
	}

	
	
	
	
}
