package com.revature.application;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import com.revature.model.Account;
import com.revature.model.BankUser;
import com.revature.service.AccountService;
import com.revature.service.BankUserService;

public class BankActions
{
	final static Logger log = Logger.getLogger(BankActions.class);
	private static Scanner scan;
	public static void menu()
	{
		int input = 0;
		System.out.println("");
		scan = new Scanner(System.in);
	  do 
	  {
			System.out.println("Please choose an option");
			System.out.println("1: Login \n2: Create Account \n3: exit");
			try 
			{
				input = scan.nextInt();
			} 
			catch (Exception e) 
			{
				
			}
			  
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
						break;
					}
			
					default: input = 3;
							break;
				}
		    } 
		    while(input != 3);
			scan.close();		
	}
	
	
	
	public static void Login()
	{
		Scanner sc = new Scanner(System.in);
		String answer = "";
		String response = "";	
		do 
		{
		System.out.println("Please enter your username");
		answer = sc.nextLine();
		System.out.println("Please enter your password");
		response = sc.next();
		BankUser user = new BankUser();
		Iterator<BankUser> it = BankUserService.getAllUsers().iterator();
		while(it.hasNext())
		{
			user = it.next();
			if ((user.getUsername().equals(answer)) && (user.getPassword().equals(response)))
			{
			
				break;
			}
		}
		
		if(user.isAdmin()==1)
		{
			AdminActions(user);
		}
		else if(user.isApproved()== 1)
		{
			UserActions(user);
		}
		else 
		{
			System.out.println("Your Status has not yet been approved");
		}
		}while(!answer.equals("exit"));
		sc.close();
	}
	
	public static void UserActions(BankUser user)
	{
		int input = 0;
		int answer = 0;
		String response = "";
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		    do 
		    {	    
		    	System.out.println("Please choose an option");
				System.out.println("1: View Account Balance \n2: Withdraw \n3: Deposit \n4: Transfer \n5: Exit");
				input = sc.nextInt();
		    	switch (input)
				{
					case 1: // View Account Balance
					{
						
						System.out.println("Which account would you like to view?");
						response = sc.next();
						AccountService.getAccount(user.getUserID(),response);
					}
							break;
					case 2: // Withdraw
					{
						System.out.println("How much would you like to withdraw?");
						answer = sc.nextInt();
						System.out.println("From which account?");
						response = sc.next();
						Account acc = AccountService.getAccount(user.getUserID(),response);
						try {
							TimeUnit.SECONDS.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Withdraw(answer, acc);
					}
							break;
					case 3: // Deposit
					{
						System.out.println("How much would you like to deposit?");
						answer = sc.nextInt();
						System.out.println("From which account?");
						response = sc.next();
						Account acc = AccountService.getAccount(user.getUserID(),response);
						Deposit(answer, acc);
					}
		                 	break;
					case 4:// Transfer
					{
						System.out.println("How much would you like to transfer?");
						answer = sc.nextInt();
						System.out.println("From which account?");
						response = scan.next();
						Account acc1 = AccountService.getAccount(user.getUserID(),response);
						System.out.println("To which account?");
						response = sc.next();
						Account acc2 = AccountService.getAccount(user.getUserID(),response);
						Transfer(answer,acc1,acc2);
					}
							break;
					default: input = 5;
							break;
				}
		    } while(input != 5);
		    sc.close();
	}
	
	
	
	public static void AdminActions(BankUser user)
	{
		int input = 0;
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		String response = "";
		System.out.println("");
		    do 
		    {	    
		    	System.out.println("Please choose an option");
				System.out.println("1: Approve Users \n2: Approve Admins \n3: Delete Users \n4: Delete Accounts \n5: Exit");
				input = sc.nextInt();
		    	switch (input)
				{
					case 1: // Approve Users
					{
						BankUser user1 = new BankUser();
						Iterator<BankUser> it = BankUserService.getAllUsers().iterator();
						while(it.hasNext())
						{
							user1 = it.next();
							if (user.isApproved()==0)
							{
								System.out.println(user1);
							}
						}
						System.out.println("What account would you like to approve?");
						answer = sc.nextInt();
						user1 = BankUserService.getUser(answer);
						ApproveUser(user1);
						
					}
							break;
					case 2: //Approve Admins
					{
						BankUser user1 = new BankUser();
						Iterator<BankUser> it = BankUserService.getAllUsers().iterator();
						while(it.hasNext())
						{
							user1 = it.next();
							if (user.isApproved()==0)
							{
								System.out.println(user1);
							}
						}
						System.out.println("What account would you like to approve?");
						answer = sc.nextInt();
						user1 = BankUserService.getUser(answer);
						MakeAdmin(user1);
					}
							break;
					case 3: // Delete Users
					{
						BankUser user1 = new BankUser();
						Iterator<BankUser> it = BankUserService.getAllUsers().iterator();
						while(it.hasNext())
						{
							user1 = it.next();
							System.out.println(user1);
						}
						System.out.println("What user would you like to delete?");
						answer = sc.nextInt();
						DeleteUser(answer);
					}
		                 	break;
					case 4:// Delete Account
					{
						Account acc = new Account();
						Iterator<Account> it = AccountService.getAllAccounts().iterator();
						while(it.hasNext())
						{
							acc = it.next();
							System.out.println(acc);
						}
						System.out.println("What account would you like to delete?");
						response = sc.nextLine();
						System.out.println("From what user??");
						answer = sc.nextInt();
						acc = AccountService.getAccount(answer, response);
						DeleteAccount(acc.getAccountID());
					}
							break;
					default: input = 5;
							break;
				}
		    }  while(input != 5);
		    sc.close();
	}
	
	
	public static void CreateUser()
	{
		String firstName;
		String lastName;
		String username;
		String password;
		System.out.println("Please enter a Username");
		username = scan.next();
		System.out.println("Please enter a Password");
		password = scan.next();
		System.out.println("Please enter your First Name");
		firstName = scan.next();
		System.out.println("Please enter your Last Name");
		lastName = scan.next();
		BankUser user = new BankUser(firstName,lastName,username,password,0,0);
		log.info(BankUserService.insertUser(user));
		System.out.println("Your User Id is:" + user.getUserID());
	}
	
	
	public static void CreateAdmin()
	{
		String firstName;
		String lastName;
		String username;
		String password;
		System.out.println("Please enter a Username");
		username = scan.next();
		System.out.println("Please enter a Password");
		password = scan.next();
		System.out.println("Please enter your First Name");
		firstName = scan.next();
		System.out.println("Please enter your Last Name");
		lastName = scan.next();
		BankUser user = new BankUser(firstName,lastName,username,password,1,1);
		log.info(BankUserService.insertUser(user));
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
