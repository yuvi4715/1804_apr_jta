package com.revature.service;

import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.model.Account;

public class AccountService
{

	
	private static AccountDAO dao = new AccountDAOImpl();
	
	
	public static boolean insertAccount(Account account) 
	{
		return dao.insertAccount(account);
	}

	
	public static Account getAccount(int userID ,String accountName) 
	{
		return dao.getAccount(userID,accountName);
	}

	public static List<Account> getAllAccounts() 
	{
		return dao.getAllAccounts();
	}

	public  static boolean updateAccount(int userID,int accountID, int balance)
	{
		return dao.updateAccount(userID,accountID,balance);
	}

	public static boolean deleteAccount(int accountID) 
	{
		return dao.deleteAccount(accountID);
	}
	
	
}
