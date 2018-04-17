package com.revature.application;

import com.revature.model.Account;
import com.revature.model.BankUser;
import com.revature.service.AccountService;
import com.revature.service.BankUserService;

public class BankApp
{
	public static void main(String args[])
	{
		//BankActions.menu();
		
		System.out.println("--CREATE A USER NAMED JOE SHMOE "
				+ " USERNAME: joe PASSWORD: nobody --");
		BankUser user = new BankUser("Joe","Shmoe","joe","nobody",0,0);
		//BankUserService.insertUser(user);
		System.out.println("--JOE IS NOT YET APPROVED AND CANNOT MAKE TRANSACTIONS--");
		boolean isAdmin = user.isApproved()==0 ? false : true;
		System.out.println("Joe is Approved Status: " + isAdmin);
		System.out.println("--Admin John Smith Approves Him");
		BankUser admin = new BankUser("John", "Smith", "SmithJohn", "password",1,1);
		BankUserService.getAllUsers();
		isAdmin = admin.isApproved()==1 ? false : true;
		
		BankUserService.updateUserStatus(user);
		System.out.println("--JOE IS NOT YET APPROVED AND CANNOT MAKE TRANSACTIONS--");
		isAdmin = user.isApproved()==0 ? true : false;
		System.out.println("Joe is Approved Status: " + isAdmin);
		BankUserService.getAllUsers();
		System.out.println("--JOE CREATES A CHECKING AND SAVINGS ACCOUNT EACH WITH $500--");
		Account checking = new Account(12350,6801,"CHECKING",500);
		Account savings = new Account(12350,6802,"SAVINGS",500); 
		//AccountService.insertAccount(checking);
		//AccountService.insertAccount(savings);
		AccountService.getAllAccounts();
		BankActions.Deposit(600, checking);
		BankActions.Withdraw(200, savings);
		BankActions.Transfer(400, savings,checking);
		AccountService.getAllAccounts();
		BankUserService.deleteUser(user.getUserID());
		BankUserService.getAllUsers();
		//BankActions.Transfer(200, acc1,acc);
	}
}
  