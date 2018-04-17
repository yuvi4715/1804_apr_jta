package Accounts;

import Bank.UserAccount;

public class AdminAccount extends Account
{
private static final long serialVersionUID = 1L;
	
	public AdminAccount(String pass, String newUser)
	{
		this.setAuth(true);
		this.setUser(newUser);
		this.setPassword(pass);
	}
	
	public void Authorize(UserAccount a)
	{
		a.setAuth(true);
	}
}
