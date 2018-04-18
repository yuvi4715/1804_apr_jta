package com.revature.model;

import java.io.Serializable;

public class BankAdmin implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5822255680971346718L;
	private int adminID;
	private String userName;
	private String passPhrase;
	
	public BankAdmin(int adminID, String userName, String passPhrase) {
		super();
		this.adminID = adminID;
		this.userName = userName;
		this.passPhrase = passPhrase;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassPhrase() {
		return passPhrase;
	}

	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminID;
		result = prime * result + ((passPhrase == null) ? 0 : passPhrase.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAdmin other = (BankAdmin) obj;
		if (adminID != other.adminID)
			return false;
		if (passPhrase == null) {
			if (other.passPhrase != null)
				return false;
		} else if (!passPhrase.equals(other.passPhrase))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAdmin [adminID=" + adminID + ", userName=" + userName + ", passPhrase=" + passPhrase + "]";
	}
	
	
	
	
	
	
}
