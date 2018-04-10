package Bank;

public class UserAccount extends Account 
{
	private static final long serialVersionUID = 1L;
	
	private String Name;
	
	public UserAccount(String n, int accNum, String pass, String newUser)
	{
		this.setAuth(false);
		Name = n;
		this.setUser(newUser);
		this.setPassword(pass);
	}
	
	public UserAccount(String n, int accNum, double newBalance, String pass, String newUser)
	{
		this.setAuth(false);
		Name = n;
		this.setBalance(newBalance);
		this.setUser(newUser);
		this.setPassword(pass);
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
