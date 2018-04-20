package com.revature.model;

public class user {
	private String username = null, password = null, firstname = null, lastname = null, email = null,
			address = null;
	private boolean isActive = false, isAdmin = false;
	private double balance = 0;
	private accounts Checking;
	private accounts Savings;
	
	
	public String getPassword() {
		return password;
	}
	public user(String username, String password, String firstname, String lastname, String email, String address,
			boolean isActive, boolean isAdmin, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
		this.balance = balance;
	}
	
	
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public accounts getChecking() {
		return Checking;
	}
	public void setChecking(accounts checking) {
		Checking = checking;
	}
	public accounts getSavings() {
		return Savings;
	}
	public void setSavings(accounts savings) {
		Savings = savings;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
		user other = (user) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public user(String username, String firstname, String lastname, String email, String address, boolean isActive,
			boolean isAdmin, double balance) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", address=" + address + ", isActive=" + isActive + ", isAdmin=" + isAdmin + "]";
	}
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}		
	
	
	
	
	
	
}

