//John Eifert
package dao;

import java.util.ArrayList;

import accounts.AdminAccount;
import accounts.UserAccount;



public interface AccountDAO
{
	//UserAccount table interactions:
	public boolean insertUserAccount(UserAccount acct);
	public UserAccount getUserAccount(long acctNumber);
	public UserAccount getUserAccount(String name);
	public ArrayList<UserAccount> getAllUserAccounts();
	public boolean updateUserAccount(UserAccount acct);
	public boolean deleteUserAccount(UserAccount acct);
	
	//AdminAccount table interactions:
	public boolean insertAdminAccount(AdminAccount acct);
	public AdminAccount getAdminAccount(long acctNumber);
	public AdminAccount getAdminAccount(String name);
	public ArrayList<AdminAccount> getAllAdminAccounts();
	public boolean updateAdminAccount(AdminAccount acct);
}
