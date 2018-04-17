package com.revature.model;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.banklogging.CuongIncLogging;
import com.revature.service.BankCustomerService;

public class Administrator implements Serializable  {
	final static Logger log = Logger.getLogger(CuongIncLogging.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Administrator fields
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	//An empty constructor is needed to create a new instance
	//via reflection JDBC
	public Administrator() {
	}

	//Constructor of administrator with fields
	public Administrator(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	public void activateAccount() {
		Scanner user = new Scanner(System.in);
		String accountActivate = user.nextLine();
		BankCustomer accountVerify = BankCustomerService.getBankCustomer(accountActivate);
		accountVerify.setAccesslevel(1);
		BankCustomerService.approveBankCustomer(accountVerify);
		System.out.println();
		System.out.println("The account " + accountVerify.getUsername() + " has successfully been activated and is ready for use.");
		System.out.println();
		System.out.println();
		log.info("A customer account was approved: " + accountVerify.getUsername() + ".");
		System.out.println();
	}

	//hash code
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	//to String
	@Override
	public String toString() {
		return "Administrator [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
	
}

