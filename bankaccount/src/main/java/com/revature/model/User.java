package com.revature.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 3379473633834375157L;
	private int isAdmin = 0;
    private int isApproved = 0;
    private String firstName = "";
    private String lastName = "";
    private int accountNumber = 0;
    private double balance = 0;
    private String passwd = "";
    
    public User() {
    
    }

	public User(int isAdmin, int isApproved, String firstName, String lastName, int accountNumber, double balance, String passwd) {
		super();
		this.isAdmin = isAdmin;
		this.isApproved = isApproved;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
        this.balance = balance;
        this.passwd = passwd;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public int getIsApproved() {
		return isApproved;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
    }
    
    public String getPass(){
        return passwd;
    }

	@Override
	public String toString() {
		return "User [isAdmin=" + isAdmin + ", isApproved=" + isApproved + ", firstName=" + firstName + ", lastName="
				+ lastName + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
    
    
}