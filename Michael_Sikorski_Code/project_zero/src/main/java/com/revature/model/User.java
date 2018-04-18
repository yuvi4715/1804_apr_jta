package com.revature.model;

import java.io.Serializable;

import com.revature.application.Project0;
import com.revature.application.DAOImplementation;

public abstract class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String email;
	private boolean isAdmin;
	
	public User() {}
	
	public User(String name, boolean admin, String email) {
		super();
		userName = name;
		isAdmin = admin;
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void performAction(User u, int index) {
		if (u.isAdmin) {
			if (index == 1) {
				DAOImplementation.getInstance().showAllAccounts();
				return;
			} else if (index == 2) {
				DAOImplementation.getInstance().approveAccounts();
			} else if (index == 3) {
				DAOImplementation.getInstance().showAllTransactions();
			} else if (index == 4) {
				Project0.logoff();
			} else {
				System.out.println("Invalid command");
			}
		} else {
			if (index == 1) {
				System.out.println("Your balance is: $" + DAOImplementation.getInstance().getBalance(this.userName) + "\n");
			} else if (index == 2) {
				DAOImplementation.getInstance().withdraw(this.userName);
			} else if (index == 3) {
				DAOImplementation.getInstance().deposit(this.userName);
			} else if (index == 4) {
				Project0.logoff();
			} else {
				System.out.println("Invalid command");
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "User [userName=" + userName + ", email=" + email + ", isAdmin=" + isAdmin + "]";
	}
	
	

}
