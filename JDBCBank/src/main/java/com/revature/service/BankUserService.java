package com.revature.service;

import java.util.List;

import com.revature.dao.BankUserDAO;
import com.revature.dao.BankUserDAOImpl;
import com.revature.model.BankUser;

public class BankUserService {
	
	
	public static BankUserDAO dao = new BankUserDAOImpl();
	
	public static boolean insertUser(BankUser user) 
	{
		return dao.insertUser(user);
	}


	public static BankUser getUser(int userID) 
	{
		return dao.getUser(userID);
	}


	public static List<BankUser> getAllUsers()
	{
		return dao.getAllUsers();
	}


	public static boolean updateUserStatus(BankUser user) 
	{
		return dao.updateUserStatus(user);
	}

	public static boolean updateUserAdmin(BankUser user)
	{
		return dao.updateUserAmin(user);
	}
	
	public static boolean deleteUser(int userID) 
	{
		return dao.deleteUser(userID);
	}
	

}
