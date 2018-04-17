package com.revature.model;

import java.io.Serializable;

public class BankUser implements Serializable 
{

	private static final long serialVersionUID = -2053804709084329624L;
	private int userID;
	private String fisrtName;
	private String lastName;
	private String username;
	private String password;
	private boolean isApproved;
	private boolean isAdmin;
	
	public BankUser() {}

	public BankUser(int userID, String fisrtName, String lastName, String username, String password) 
	{
		super();
		this.userID = userID;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.isApproved = false;
		this.isAdmin = false;
	}
	
	

	@Override
	public String toString() {
		return "BankUser [userID: " + userID + "| Name: " + fisrtName + " " + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fisrtName == null) ? 0 : fisrtName.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + (isApproved ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		BankUser other = (BankUser) obj;
		if (fisrtName == null) {
			if (other.fisrtName != null)
				return false;
		} else if (!fisrtName.equals(other.fisrtName))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (isApproved != other.isApproved)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	} 
		
}
