//John Eifert
package accounts;

import org.apache.log4j.Logger;



public class UserAccount extends Account implements Transactable
{
	final static Logger logger = Logger.getLogger(UserAccount.class);
	
	private double balance;
	
	
	public UserAccount(String h, String p, long a, int app)
	{
		this.holder = h;
		this.password = p;
		this.acctNumber = a;
		this.balance = 0;
		this.approved = app;
	}
	public UserAccount(String h, String p, long a, double b, int app)
	{
		this.holder = h;
		this.password = p;
		this.acctNumber = a;
		this.balance = b;
		this.approved = app;
	}
	
	
	public double getBalance()
	{
		return(this.balance);
	}
	
	
	private boolean addFunds(long amount)
	{
		if(this.approved != 1)
		{
			System.out.println("An account cannot recieve funds until it has been approved.");
			logger.info("An account cannot recieve funds until it has been approved.");
			return(false);
		}
		
		if(amount <= 0)
		{
			System.out.println("The provided amount, " + amount + ", is invalid for this operation.");
			logger.info("The provided amount, " + amount + ", is invalid for this operation.");
			return(false);
		}
		
		try
		{
			System.out.println(this.holder + "'s Account starting balance = " + this.balance);
			logger.info(this.holder + "'s Account starting balance = " + this.balance);
			this.balance+=amount;
			System.out.println(this.holder + "'s Account ending balance = " + this.balance);
			logger.info(this.holder + "'s Account ending balance = " + this.balance);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return(false);
		}
		
		System.out.println("Fund addition was successful.");
		logger.info("Fund addition was successful.");
		return(true);
	}
	
	private boolean removeFunds(long amount)
	{
		if(this.approved != 1)
		{
			System.out.println("Funds cannot be removed from an account until it has been approved.");
			return(false);
		}
		
		if(amount <= 0)
		{
			System.out.println("The provided amount, " + amount + ", is invalid for this operation.");
			return(false);
		}
		
		try
		{
			System.out.println(this.holder + "'s Account starting balance = " + this.balance);
			this.balance-=amount;
			System.out.println(this.holder + "'s Account ending balance = " + this.balance);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return(false);
		}
		
		System.out.println("Fund removal was successful.");
		return(true);
	}


	@Override
	public boolean deposit(long amount)
	{
		System.out.println("Beginning the deposit process...");
		try
		{
			if(addFunds(amount))
			{
				System.out.println("Deposit was successful.");
				return(true);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Deposit was not successful.");
		return(false);
	}

	@Override
	public boolean withdraw(long amount)
	{
		System.out.println("Beginning the withdrawal process...");
		try
		{
			if(removeFunds(amount))
			{
				System.out.println("Withdrawal was successful.");
				return(true);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("Withdrawal was not successful.");
		return(false);
	}
}
