//John Eifert
package service;

import java.util.List;

import accounts.UserAccount;
import dao.AccountDAO;
import dao.AccountDAOImpl;



public class AccountService
{
	private static AccountDAO dao = AccountDAOImpl.getInstance();
	
	public static List<UserAccount> getAllUserAccounts()
	{
		return(dao.getAllUserAccounts());
	}
}
