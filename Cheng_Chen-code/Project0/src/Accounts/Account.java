package Bank;

import java.io.Serializable;

public abstract class Account implements Serializable
{
	//account number initialized at creation, is the 
	private static final long serialVersionUID = 1L;
	private double balance = 0;
	private boolean Auth;
	private String password;
	private String username;
	
	protected void setPassword(String newPass)
	{
		password = newPass;
	}
	
	protected void setUser(String newUser)
	{
		username = newUser;
	}
	
	protected void setBalance(double newB)
	{
		balance = newB;
	}
	
	protected void setAuth(boolean a)
	{
		Auth = a;
	}
	
	public String getUser()
	{
		return username;
	}
	
	public String getPass()
	{
		return password;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public boolean getAuth()
	{
		return Auth;
	}
	
	public void deposit(double amount) throws NegativeDepositException
	{
		if(amount <= 0)
			throw new NegativeDepositException();
		else
			balance += amount;
	}
	
	public void withdraw(double amount) throws NegativeDepositException, WithdrawOverException
	{
		if(amount <= 0)
			throw new NegativeDepositException();
		else if(amount > balance)
			throw new WithdrawOverException();
		else 
			balance -= amount;
	}
}

class NegativeDepositException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

class WithdrawOverException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
