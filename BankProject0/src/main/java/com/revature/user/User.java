package com.revature.user;

import java.io.Serializable;

public class User implements Serializable {
	
	
	private static final long serialVersionUID = -8102097302659209061L;
	private int accountNumber;
	private String email;
	private double balance;
	private boolean notCustomer;
	private String firstName;
	private String lastName;
	private String password;
	private boolean isAdmin;
	
	public User() {
		
	}

	public User(int accountNumber, String email, double balance, String firstName, String lastName, boolean isAdmin
			, boolean notCustomer ,String password) {
		
		this.accountNumber = accountNumber;
		this.email = email;
		this.balance = balance;
		this.notCustomer = notCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.password = password;
		
	}
	
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean getNotCustomer() {
		return this.notCustomer;
	}
	public void setNotCustomer(boolean notCustomer) {
		this.notCustomer = notCustomer;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (notCustomer ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (notCustomer != other.notCustomer)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [accountNumber=" + accountNumber + ", email=" + email + ", balance=" + balance + ", notCustomer="
				+ notCustomer + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}

	
	

}
