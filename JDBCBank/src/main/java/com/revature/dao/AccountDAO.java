package com.revature.dao;

import java.util.List;
import com.revature.model.Account;


public interface AccountDAO 
{
	public boolean insertAccount(Account account);	// Create
	public Account getAccount(int userID, String accountName);	// Read
	public List<Account> getAllAccounts();		// Read
	public boolean updateAccount(int UserId, int accountID,int balance);	// Update
	public boolean deleteAccount(int accountID); // Delete

}
