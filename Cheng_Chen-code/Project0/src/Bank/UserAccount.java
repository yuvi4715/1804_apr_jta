package Bank;

import Accounts.Account;

public class UserAccount extends Account 
{
	private static final long serialVersionUID = 1L;
	
	private String Name;
	
	public UserAccount(String n, String newUser, String pass)
	{
		this.setAuth(false);
		Name = n;
		this.setUser(newUser);
		this.setPassword(pass);
	}
	
	public UserAccount(String n, String newUser, String pass, double balance, boolean auth)
	{
		this.setAuth(auth);
		this.setBalance(balance);
		Name = n;
		this.setUser(newUser);
		this.setPassword(pass);
	}
	
	public String getName()
	{
		return Name;
	}
	
	public boolean checkAuth() throws UnauthorizedException
	{
		if(this.getAuth())
			return true;
		else
			throw new UnauthorizedException();
	}
	
	public void deposit(double amount)
	{
		if(this.checkAuth())
		{
			super.deposit(amount);
		}
	}
	
	public void withdraw(double amount)
	{
		if(this.checkAuth())
		{
			super.withdraw(amount);
		}
	}
}

class UnauthorizedException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
