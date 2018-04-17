package com.revature.dao;

import java.util.List;
import com.revature.model.BankUser;

public interface BankUserDAO 
{
	public boolean insertUser(BankUser user);	// Create
	public BankUser getUser(int userID );	// Read
	public List<BankUser> getAllUsers();		// Read
	public boolean updateUserStatus(BankUser user);	// Update
	public boolean updateUserAmin(BankUser user);  // Update
	public boolean deleteUser(int userID); // Delete

}
