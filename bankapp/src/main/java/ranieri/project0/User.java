package ranieri.project0;

import java.util.ArrayList;

public class User {
	
	
	private String username;
	private String password;
	private String role = "customer";
	private ArrayList<String> history;
	int authorized = 0;
	private double balance = 0;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;		
		
	}
	
	public User(String username, String password, int authorized, double balance) {
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
		//history.add(note);
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
	
	public String getRole() {
		return role;
	}
	
	public int getAuth() {
		return this.authorized;
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


	
	
	
	

}
