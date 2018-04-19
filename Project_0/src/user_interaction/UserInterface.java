//John Eifert
package user_interaction;

import java.util.Scanner;
import java.util.ArrayList;

import accounts.*;
import dao.*;

import accounts.AdminAccount;
import accounts.UserAccount;
import dao.AccountDAOImpl;



public class UserInterface
{
	public static int CreateOrSignIn()
	{
		Scanner in = new Scanner(System.in);
		String input;
		int decision=0;
		boolean isValid=false;
		while(!isValid)
		{
			System.out.println("Enter '1' if you would like to create a new account.");
			System.out.println("Enter '2' if you would like to sign in to an existing account:");
			input = in.nextLine();
			
			try
			{
				isValid=true;
				decision=Integer.parseInt(input);
				if(decision != 1 && decision != 2)
				{
					isValid=false;
					System.out.println("You appear to have entered an invalid option number.  Please try again.");
				}
			}
			catch(Exception e)
			{
				isValid=false;
				System.out.println("There was a problem reading your option number.  Please try again.");
			}
		}
		return(decision);
	}
	
	
	public static int SignInOption()
	{
		Scanner in = new Scanner(System.in);
		String input;
		int option=0;
		
		while(true)
		{
			System.out.println("Enter '1' if you would like to sign in to a user account.");
			System.out.println("Enter '2' if you would like to sign in to an admin account:");
			input = in.nextLine();
			
			try
			{
				option=Integer.parseInt(input);
				if(option == 1 || option ==2)
				{
					switch(option)
					{
						case 1:
							System.out.println("You have chosen to sign in to a user account.");
							return(option);
						case 2:
							System.out.println("You have chosen to sign in to an admin account.");
							return(option);
					}
				}
				else
				{
					System.out.println("You appear to have entered an invalid option number.  Please try again.");
				}
			}
			catch(Exception e)
			{
				System.out.println("There was a problem reading your option number.  Please try again.");
			}
		}
	}
	
	public static AdminAccount AdminSignIn(AccountDAOImpl DAO)
	{
		System.out.println("Now starting the AdminSignIn method...");
		Scanner in = new Scanner(System.in);
		String input;
		long longInput=0;
		AdminAccount adminAcct;
		
		while(true)
		{
			System.out.println("Please enter your name or account number:");
			input = in.nextLine();
			
			System.out.println("Now attempting to sign you in to an existing admin account.");
			try
			{
				System.out.println("Checking to see if the provided input is an account number...");
				longInput = Long.parseLong(input);
				System.out.println("The provided input appears to be an account number.");
				
				System.out.println("Now calling getAdminAccount(long acctNumber)...");
				adminAcct = DAO.getAdminAccount(longInput);
				System.out.println("getAdminAccount(long acctNumber) has finished executing.");
				
				if(adminAcct != null)
				{
					System.out.println("A non-null admin account has been retrieved.");
					return(adminAcct);
				}
			}
			catch(Exception e)
			{
				System.out.println("The provided input does not appear to be an account number.");
				
				System.out.println("Now calling getAdminAccount(String name)...");
				adminAcct = DAO.getAdminAccount(input);
				System.out.println("getAdminAccount(String name) has finished executing.");
				
				if(adminAcct != null)
				{
					System.out.println("A non-null admin account has been retrieved.");
					return(adminAcct);
				}
				else
				{
					System.out.println("A problem occurred with the retrieval of your admin account.  Please try again.");
				}
			}
		}
	}
	
	public static UserAccount UserSignIn(AccountDAOImpl DAO)
	{
		System.out.println("Now starting the AdminSignIn method...");
		Scanner in = new Scanner(System.in);
		String input;
		long longInput=0;
		UserAccount userAcct;
		
		while(true)
		{
			System.out.println("Please enter your name or account number:");
			input = in.nextLine();
			
			System.out.println("Now attempting to sign you in to an existing user account.");
			try
			{
				System.out.println("Checking to see if the provided input is an account number...");
				longInput=Long.parseLong(input);
				System.out.println("The provided input appears to be an account number.");
				
				System.out.println("Now calling getUserAccount(long acctNumber)...");
				userAcct = DAO.getUserAccount(longInput);
				System.out.println("getUserAccount(long acctNumber) has finished executing.");
				
				if(userAcct != null)
				{
					System.out.println("A non-null user account has been retrieved.");
					return(userAcct);
				}
			}
			catch(Exception e)
			{
				System.out.println("The provided input does not appear to be an account number.");
				
				System.out.println("Now calling getUserAccount(String name)...");
				userAcct = DAO.getUserAccount(input);
				System.out.println("getUserAccount(String name) has finished executing.");
				
				if(userAcct != null)
				{
					System.out.println("A non-null user account has been retrieved.");
					return(userAcct);
				}
				else
				{
					System.out.println("A problem occurred with the retrieval of your admin account.  Please try again.");
				}
			}
		}
	}
	
	
	public static void CreateAccount(AccountDAOImpl DAO)
	{
		System.out.println("Now entering account creation...");
		
		Scanner in = new Scanner(System.in);
		String input;
		String password;
		String name;
		int choice=0;
		long number=0;
		boolean success=false;
		
		while(true)
		{
			System.out.println("Enter '1' if you would like to create a user account.");
			System.out.println("Enter '2' if you would like to create an admin account:");
			input = in.nextLine();
			
			try
			{
				choice = Integer.parseInt(input);
				if(choice == 1 || choice == 2)
				{
					switch(choice)
					{
						case 1:
							System.out.println("You have chosen to create a new user account.");
							break;
						case 2:
							System.out.println("You have chosen to create a new admin account");
							break;
					}
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("There was a problem reading your option number.  Please try again.");
			}
		}
		
		System.out.println("Please enter your name:");
		name = in.nextLine();
		System.out.println("Please enter a password:");
		password = in.nextLine();
		
		number+=DAO.getAllUserAccounts().size();
		number+=DAO.getAllAdminAccounts().size();
		number++;
		
		if(choice == 1)
		{
			System.out.println("Now creating a new user account with the provided information...");
			DAO.insertUserAccount(new UserAccount(name, password, number, 0));
		}
		else
		{
			System.out.println("Now creating a new admin account with the provided information...");
			DAO.insertAdminAccount(new AdminAccount(name, password, number, 0));
		}
	}
	
}
