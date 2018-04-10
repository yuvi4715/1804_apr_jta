package Bank;

public class AdminAccount extends Account
{
private static final long serialVersionUID = 1L;
	
	private String Name;
	
	public AdminAccount(String n, int accNum, String pass, String newUser)
	{
		this.setAuth(false);
		Name = n;
		this.setUser(newUser);
		this.setPassword(pass);
	}
	
	public AdminAccount(String n, int accNum, double newBalance, String pass, String newUser)
	{
		this.setAuth(false);
		Name = n;
		this.setBalance(newBalance);
		this.setUser(newUser);
		this.setPassword(pass);
	}
}
