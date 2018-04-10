package Bank;

public class AdminAccount extends Account
{
private static final long serialVersionUID = 1L;
	
	private String Name;
	
	public AdminAccount(String n, int accNum, String pass, String newUser)
	{
		this.setAuth(true);
		Name = n;
		this.setUser(newUser);
		this.setPassword(pass);
	}
	
	public void Authorize(UserAccount a)
	{
		a.setAuth(true);
	}
}
