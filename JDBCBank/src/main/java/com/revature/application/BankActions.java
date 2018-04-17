package com.revature.application;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.revature.model.Account;
import com.revature.model.BankUser;
import com.revature.service.AccountService;
import com.revature.service.BankUserService;

public class BankActions
{
	final static Logger log = Logger.getLogger(BankActions.class);
	public static void menu()
	{
		int input = 0;
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please choose an option");
		System.out.println("1: Login \n2: Create Account \n3: exit");
		input = scan.nextInt();
		    do 
		    {	    	
		    	switch (input)
				{
					case 1: 
					{
						Login();
					}
							break;
					case 2: 
					{
						CreateUser();
					}
							break;
					default: input = 3;
							break;
				}
		    } 
		    while(input != 3);
			scan.close();		
	}
	
	
	
	public static void Login()
	{
		
	}
	
	public static void UserActions(BankUser user)
	{
		int input = 0;
		int answer = 0;
		int temp;
		String response = "";
		System.out.println("");
		Scanner scan = new Scanner(System.in);
	
		    do 
		    {	    
		    	System.out.println("Please choose an option");
				System.out.println("1: View Account Balance \n2: Withdraw \n3: Deposit \n4: Transfer \n5: Exit");
				input = scan.nextInt();
		    	switch (input)
				{
					case 1: // View Account Balance
					{
						
						System.out.println("Which account would you like to view?");
						response = scan.nextLine();
						AccountService.getAccount(user.getUserID(),response);
					}
							break;
					case 2: // Withdraw
					{
						System.out.println("How much would you like to withdraw?");
						answer = scan.nextInt();
						System.out.println("From which account?");
						response = scan.nextLine();
						Account acc = AccountService.getAccount(user.getUserID(),response);
						Withdraw(answer, acc);
					}
							break;
					case 3: // Deposit
					{
						System.out.println("How much would you like to deposit?");
						answer = scan.nextInt();
						System.out.println("From which account?");
						response = scan.nextLine();
						Account acc = AccountService.getAccount(user.getUserID(),response);
						Deposit(answer, acc);
					}
		                 	break;
					case 4:// Transfer
					{
						System.out.println("How much would you like to transfer?");
						answer = scan.nextInt();
						System.out.println("From which account?");
						response = scan.nextLine();
						Account acc1 = AccountService.getAccount(user.getUserID(),response);
						System.out.println("To which account?");
						response = scan.nextLine();
						Account acc2 = AccountService.getAccount(user.getUserID(),response);
						Transfer(answer,acc1,acc2);
					}
							break;
					default: input = 5;
							break;
				}
		    } 
		    while(input != 5);
			scan.close();
		
	}
	
	public static void CreateUser()
	{
		String firstName;
		String lastName;
		String username;
		String password;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a Username");
		username = scan.next();
		System.out.println("Please enter a Password");
		password = scan.next();
		System.out.println("Please enter your First Name");
		firstName = scan.next();
		System.out.println("Please enter your Last Name");
		lastName = scan.next();
		BankUser user = new BankUser(0,firstName,lastName,username,password);
		log.info(BankUserService.insertUser(user));
		scan.close();
	}
	
	
	public static void CreateAdmin()
	{
		String firstName;
		String lastName;
		String username;
		String password;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a Username");
		username = scan.next();
		System.out.println("Please enter a Password");
		password = scan.next();
		System.out.println("Please enter your First Name");
		firstName = scan.next();
		System.out.println("Please enter your Last Name");
		lastName = scan.next();
		BankUser user = new BankUser(0,firstName,lastName,username,password);
		log.info(BankUserService.insertUser(user));
		BankUserService.updateUserStatus(user);
		BankUserService.updateUserAdmin(user);
		scan.close();
	}
	
	public static void Deposit(int amount, Account acc)
	{
		int oldBal = acc.getBalance();
		int balance = oldBal + amount;
		log.info(AccountService.updateAccount(acc.getUserID(),acc.getAccountID(),balance));
	}
	
	public static void Withdraw(int amount, Account acc)
	{
		int oldBal = acc.getBalance();
		int balance = oldBal - amount;
		if (balance < 0)
		{
			System.out.println("I'm sorry, you have insufficient funds to complete this transaction. ");
		}
		else 
		{
			log.info(AccountService.updateAccount(acc.getUserID(),acc.getAccountID(),balance));
		}
	}
	
	public static void Transfer(int amount, Account acc1,Account acc2)
	{
		int bal2 = acc2.getBalance();
		if((bal2-amount) < 0)
		{
			System.out.println("I'm sorry, you have insufficient funds to complete this transaction. ");
		}
		else
		{
			Withdraw(amount,acc2);
			Deposit(amount,acc1);
		}	
	}
	
	
	public static void ApproveUser(BankUser user)
	{
		BankUserService.updateUserStatus(user);
	}
	
	public static void MakeAdmin(BankUser user)
	{
		BankUserService.updateUserAdmin(user);
	}
	
	public static void DeleteAccount(int accountid)
	{
		log.info(AccountService.deleteAccount(accountid));
	}
	public static void DeleteUser(int userid)
	{
		log.info(BankUserService.deleteUser(userid));
	}
}
