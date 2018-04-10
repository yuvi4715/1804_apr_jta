package Bank;

import java.io.Serializable;

public abstract class Account implements Serializable
{
	//account number initialized at creation, is the 
	private static final long serialVersionUID = 1L;
	private double balance = 0;
	private int accNo;
	private boolean Auth;
	private String password;
	private String username;
	
	public int getAccountNumber()
	{
		return accNo;
	}
	
	protected void setPassword(String newPass)
	{
		password = newPass;
	}
	
	protected void accNo(int n)
	{
		accNo = n;
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
			balance += amount;
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
