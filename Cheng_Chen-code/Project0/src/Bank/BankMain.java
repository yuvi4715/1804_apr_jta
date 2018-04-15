package Bank;
/*
 * BASIC DEMO PLAN
 * 1. FIRE UP PROGRAM
 * 2. CREATE ACCOUNT
 * 3. SHOW NO AUTHORIZATION
 * 4. AUTHORIZE ACCOUNT AS ADMIN
 * 5. LOG INTO USER ACCOUNT
 * 6. MAKE DEPOSIT/WITHDRAWLS
 * 7. ANY QUESTIONS?
 */
import org.apache.log4j.Logger;
import java.io.*;
import java.util.*;
import java.sql.*;

public class BankMain {

	final static Logger log = Logger.getLogger(BankMain.class);
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//log usage for later
		//log.info("TEST.");
		//UserAccount test = new UserAccount("John Smith", "test", "JST", 10, false);
		//System.out.println("Test Account was updated: " + BankService.updateUser(test));
		
		boolean running = true;
		
		System.out.println("Welcome to the Revature Banking Application.");
		Scanner scan = new Scanner(System.in);
		
		while(running)
		{
			System.out.println("What would you like to do?");
			System.out.println("1. Log into existing account (user).");
			System.out.println("2. Create new account.");
			System.out.println("3. Log in (admin).");
			System.out.println("4. Exit.");
			
			try 
			{
				int choice = scan.nextInt();
				
				switch(choice)
				{
					case 1: 
					{
						log.info("User selected 1.\nAttempting User Login.");
						UserLogin();
						break;
					}
					case 2: 
					{
						log.info("User selected 2.\nCreating new account.");
						CreateAccount();
						break;
					}
					case 3: 
					{
						log.info("User selected 3.\nAttempting admin login.");
						AdminLogin();
						break;
					}
					case 4: 
					{
						log.error("User selected 4.\nExiting program.");
						System.out.println("Exiting program.");
						System.exit(0);
						break;
					}
					default: 
					{
						System.err.println("Invalid Input.");
						log.error("User entered Invalid Input.");
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.err.println("Invalid Input.");
				log.error("User entered Invalid Input.");
			}
		}
		log.error("YOU SHOULD NOT SEE THIS, OR ELSE SOMETHING BROKE.");
	}
	
	public static void CreateAccount()
	{
		Scanner in = new Scanner(System.in);
    	
    	try {
	    	System.out.println("Please enter a username with no spaces:");
	    	String username = in.nextLine();
	    	username = username.trim();
	    	
	    	System.out.println("Please enter a password with no spaces:");
	    	String password = in.nextLine();
	    	password = password.trim();
	    	
	    	System.out.println("Please enter your full name: ");
	    	String name = in.nextLine();
	    	
	    	UserAccount new_user = new UserAccount(name, username, password);
	    	  	
	    	BankService.insertUser(new_user);
	    	log.info(name + " has made a new account.");
	    	System.out.println("Succesfully created a new user");
    	}
    	catch (Exception e) 
    	{
    		System.err.println("Invalid Input.");
			log.error("User entered Invalid Input.");
    	}
	}
	
	public static void UserLogin()
	{
		try
		{
			System.out.println("Please enter your username:");
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			UserAccount current = BankService.getUser(username);
			
			System.out.println("Please enter your password:");
			String password = in.nextLine();
			
			if(password.equals(current.getPass()) && current.checkAuth())
			{
				log.info("User entered correct password.");
				UserMenu(current);
				
			}
			else if(!current.checkAuth())
			{
				log.error("Unauthorized Account.");
				System.out.println("This account is currently unauthorized.");
			}
			else
			{
				log.info("User entered incorrect password.");
				System.out.println("Incorrect Username or Password.");
			}
		}
		catch(Exception e)
		{
			System.err.println("Invalid Input.");
			log.error("User entered Invalid Input.");
		}
	}
	public static void UserMenu(UserAccount user)
	{
		boolean loggedOn = true;
		while(loggedOn)
		{
			System.out.println("Welcome, " + user.getName() + "!");
			System.out.println("Please select an option below:");
			System.out.println("1. Make a deposit.");
			System.out.println("2. Make a withdrawl.");
			System.out.println("3. Log out.");
			
			try
			{
				Scanner in = new Scanner(System.in);
				int choice = in.nextInt();
				
				switch(choice)
				{
					case 1: 
					{
						System.out.println("Please enter amount to deposit: ");
						double deposit = in.nextDouble();
						makeDeposit(user, deposit);
						break;
					}
					case 2: 
					{

						System.out.println("Please enter amount to withdraw: ");
						double withdraw = in.nextDouble();
						makeWithdrawl(user, withdraw);
						break;
					}
					case 3: 
					{
						log.info("User: " + user.getUser() + "logging out.");
						loggedOn = false;
						break;
					}
					default: 
					{
						System.err.println("Invalid Input.");
						log.error("User entered Invalid Input.");
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.err.println("Invalid Input.");
				log.error("User entered Invalid Input.");
			}
		}
	}
	public static void makeDeposit(UserAccount user, double amount)
	{
		try 
		{
			user.deposit(amount);
			log.info(user.getUser() + " deposited " + amount + "into account.");
			System.out.print("Deposit completed, current balance: $");
			System.out.printf("%.1f", user.getBalance());
			BankService.updateUser(user);
		}
		catch(NegativeDepositException e)
		{
			log.error("User attempted to deposit negative amount.");
		}
	}
	public static void makeWithdrawl(UserAccount user, double amount)
	{
		try 
		{
			user.withdraw(amount);
			log.info(user.getUser() + " withdrew " + amount + "into account.");
			System.out.print("Withdrawl completed, current balance: $");
			System.out.printf("%.1f", user.getBalance());
			BankService.updateUser(user);
		}
		catch(NegativeDepositException e)
		{
			log.error("User attempted to withdraw negative amount.");
		}
		catch(WithdrawOverException e)
		{
			log.error("User attempted to withdraw more that current balance.");
		}
	}

	public static void AdminLogin()
	{
		try
		{
			System.out.println("Please enter your username:");
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			AdminAccount current = BankService.getAdmin(username);
			
			System.out.println("Please enter your password:");
			String password = in.nextLine();
			
			if(password.equals(current.getPass()))
			{
				log.info("Admin logged in.");
				AdminMenu(current);
			}
			else
			{
				log.info("Admin failed to login.");
				System.out.println("Incorrect admin username or password.");
			}
		}
		catch(Exception e)
		{
			System.err.println("Invalid Input.");
			log.error("User entered Invalid Input.");
		}
	}
	public static void AdminMenu(AdminAccount admin)
	{
		boolean loggedOn = true;
		while(loggedOn)
		{
			System.out.println("ADMIN CONSOLE.");
			System.out.println("Please select an option below:");
			System.out.println("1. See all users.");
			System.out.println("2. Authorize a user.");
			System.out.println("3. Log out.");
			
			try
			{
				Scanner in = new Scanner(System.in);
				int choice = in.nextInt();
				
				switch(choice)
				{
					case 0: 
					{
						List<UserAccount> users = BankService.getAllUsers();
						for(UserAccount a:users)
						{
							System.out.println("Name: " + a.getName() + " username: " + a.getUser() + " Authorized: " + Boolean.toString(a.getAuth()));
						}
						break;
					}
					case 2: 
					{
						AuthorizeAccount(admin);
						break;
					}
					case 3: 
					{
						log.info("Admin logging out.");
						loggedOn = false;
						break;
					}
					default: 
					{
						System.err.println("Invalid Input.");
						log.error("Invalid Input.");
						break;
					}
				}
			}
			catch(Exception e)
			{
				System.err.println("Invalid Input.");
				log.error("Invalid Input.");
			}
		}
	}
	public static void AuthorizeAccount(AdminAccount admin)
	{
		try
		{
			System.out.println("Please enter the username of the accout you wish to authorize:");
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			UserAccount toAuthorize = BankService.getUser(username);
			
			admin.Authorize(toAuthorize);
			System.out.println("Authorization successful.");
			log.info("The account " + toAuthorize.getUser() + " has been authorized.");
		}
		catch(Exception e)
		{
			System.err.println("Invalid Input.");
			log.error("User entered Invalid Input.");
		}
	}
}
