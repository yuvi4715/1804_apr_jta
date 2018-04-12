package ranieri.project0;

import java.util.ArrayList;

public class Customer {
	
	
	private String username;
	private String password;
	private ArrayList<String> history;
	boolean authorized = false;
	private double balance = 0;
	
	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;		
		
	}
	
	public Customer(String username, String password, boolean authorized, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.authorized = authorized;
		this.balance = balance;
	}
	
	// static method that checks if a name is unique in the database 
	public static boolean validName() {
		return true;
	}



	public void updateHistory(String note) {
		history.add(note);
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
	
	
	
	public boolean isAuthorized() {
		return authorized;
	}



	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}


	public double getBalance() {
		return balance;
	}

	public void deposit(double deposit) {
		this.balance = this.balance + deposit;
		this.updateHistory("Deposited $"+ deposit);
	}
	
	public void withdraw(double withdrawl) {
		
		if(this.balance>withdrawl) {
		this.balance = this.balance - withdrawl;
		this.updateHistory("withdrew $"+ withdrawl);
		
		}else {		
			System.out.println("You do not have enough money ");
			this.updateHistory("attempted to withdraw $"+ withdrawl+ " but insufficent funds");
		}
		
		
	}


	public boolean checkAuthorization() {
		
		if(authorized == true) {
			return true;
		}else {
			System.out.println("You are not authorized at this moment.");
			return false;
		}
			
		
	}

		
	
	
	
	

}
