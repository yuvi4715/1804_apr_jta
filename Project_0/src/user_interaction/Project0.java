//John Eifert
package user_interaction;

import accounts.*;
import dao.*;
import service.*;

import accounts.AdminAccount;
import accounts.UserAccount;
import dao.AccountDAOImpl;

import java.util.Scanner;
import java.util.ArrayList;
import org.apache.log4j.Logger;



public class Project0
{
	final static Logger logger = Logger.getLogger(Project0.class);
	
	public static void main(String args[])
	{
		logger.info("Welcome to John Eifert's banking application!");
		AdminAccount adminAcct = new AdminAccount(null, null, 0, 0);
		UserAccount userAcct = new UserAccount(null, null, 0, 0, 0);
		int decision=0;
		int option=0;
		int choice=0;
		long number=0;
		double amount=0;
		boolean signedIn=false;
		String input;
		boolean cont=true;
		
		
		AccountDAOImpl acctDAO = AccountDAOImpl.getInstance();
		Scanner in;
		
		
		
		decision = UserInterface.CreateOrSignIn();
		if(decision == 2)
		{
			while(!signedIn)
			{
				logger.info("Now taking you to LOGIN...");
				//GO TO SIGN IN TO EXISTING ACCOUNT
				option = UserInterface.SignInOption();
				
				System.out.println("Now forwarding you to the appropriate sign in method...");
				switch(option)
				{
					case 1:
						userAcct = UserInterface.UserSignIn(acctDAO);
						break;
					case 2:
						adminAcct = UserInterface.AdminSignIn(acctDAO);
						break;
				}
				
				if(option == 1)
				{
					in = new Scanner(System.in);
					System.out.println("Please enter your password:");
					input = in.nextLine();
					
					if(input.equals(userAcct.getPassword()))
					{
						signedIn=true;
						System.out.println("Sign in was successful.");
					}
					else
					{
						System.out.println("Provided password was incorrect.");
					}
				}
				else
				{
					in = new Scanner(System.in);
					System.out.println("Please enter your password:");
					input = in.nextLine();
					
					if(input.equals(adminAcct.getPassword()))
					{
						signedIn=true;
						System.out.println("Sign in was successful.");
					}
					else
					{
						System.out.println("Provided password was incorrect.");
					}
				}
			}
			
			
			cont=true;
			while(cont)
			{
				System.out.println("Welcome to your account.");
				
				//For user accounts:
				if(option == 1)
				{
					in = new Scanner(System.in);
					while(cont)
					{
						while(true)
						{
							System.out.println("Your balance is: $" + userAcct.getBalance() + "\n");
							System.out.println("\nEnter '1' if you would like to make a withdrawal.");
							System.out.println("Enter '2' if you would like to make a deposit.");
							System.out.println("Enter '3' if you would like to sign out.");
							
							input = in.nextLine();
							
							try
							{
								choice = Integer.parseInt(input);
								break;
							}
							catch(Exception e)
							{
								System.out.println("There was a problem reading your option number.  Please try again.");
							}
						}
						
						switch(choice)
						{
							case 1:
								if(userAcct.getApproved() != 1)
								{
									System.out.println("Your account has not been approved yet.");
									System.out.println("Only approved user accounts are permitted to make withdrawals.");
								}
								else
								{
									while(true)
									{
										try
										{
											System.out.println("Please enter the amount that you wish to withdraw:");
											input = in.nextLine();
											amount = Double.parseDouble(input);
											if(amount < 0 || amount > userAcct.getBalance())
											{
												System.out.println("You cannot withdraw that amount of money.  Please try again.");
												continue;
											}
											userAcct = new UserAccount(userAcct.getHolder(), userAcct.getPassword(), userAcct.getAcctNumber(), userAcct.getBalance()-amount, userAcct.getApproved());
											acctDAO.updateUserAccount(userAcct);
											break;
										}
										catch(Exception e)
										{
											System.out.println("There was an issue reading the amount that you entered.  Please try again.");
										}
										
									}
									
								}
								break;
							case 2:
								if(userAcct.getApproved() != 1)
								{
									System.out.println("Your account has not been approved yet.");
									System.out.println("Only approved user accounts are permitted to make deposits.");
									cont=false;
								}
								else
								{
									while(true)
									{
										try
										{
											System.out.println("Please enter the amount that you wish to deposit:");
											input = in.nextLine();
											amount = Double.parseDouble(input);
											if(amount < 0)
											{
												System.out.println("You cannot deposit a negative amount of money.  Please try again.");
												continue;
											}
											userAcct = new UserAccount(userAcct.getHolder(), userAcct.getPassword(), userAcct.getAcctNumber(), userAcct.getBalance()+amount, userAcct.getApproved());
											acctDAO.updateUserAccount(userAcct);
											break;
										}
										catch(Exception e)
										{
											System.out.println("There was an issue reading the amount that you entered.  Please try again.");
										}
									}
								}
								break;
							case 3:
								cont=false;
								break;
						}
					}
				}
				else
				{
					//For admin accounts:
					in = new Scanner(System.in);
					
					if(adminAcct.getApproved() == 1)
					{
						System.out.println("The following accounts are currently unapproved: \n");
						
						ArrayList<UserAccount> userAccts = acctDAO.getAllUserAccounts();
						ArrayList<AdminAccount> adminAccts = acctDAO.getAllAdminAccounts();
						System.out.println("Unapproved User Account(s):");
						for(int i=0; i<userAccts.size(); i++)
						{
							if(userAccts.get(i).getApproved() != 1)
							{
								System.out.print("Account Number: " + userAccts.get(i).getAcctNumber() + ", Holder Name: " + userAccts.get(i).getHolder());
								System.out.print(", Account Balance: " + userAccts.get(i).getBalance() + "\n");
							}
						}
						System.out.println("Unapproved Admin Account(s):");
						for(int i=0; i<adminAccts.size(); i++)
						{
							if(adminAccts.get(i).getApproved() != 1)
							{
								System.out.println("Account Number: " + adminAccts.get(i).getAcctNumber() + ", Holder Name: " + adminAccts.get(i).getHolder());
							}
						}
						System.out.print("\n");
						
						System.out.println("Please enter the account number of an account that you wish to approve:");
						number=Long.parseLong(in.nextLine());
						
						for(int i=0; i<userAccts.size(); i++)
						{
							if(userAccts.get(i).getAcctNumber() == number)
							{
								acctDAO.updateUserAccount(new UserAccount(userAccts.get(i).getHolder(), userAccts.get(i).getPassword(), userAccts.get(i).getAcctNumber(), 1));
							}
						}
						for(int i=0; i<adminAccts.size(); i++)
						{
							if(adminAccts.get(i).getAcctNumber() == number)
							{
								acctDAO.updateAdminAccount(new AdminAccount(adminAccts.get(i).getHolder(), adminAccts.get(i).getPassword(), adminAccts.get(i).getAcctNumber(), 1));
							}
						}
						System.out.println("The account has been successfully approved.");
						
					}
					else
					{
						System.out.println("Your account has not been approved yet.");
						System.out.println("Only approved admin accounts are permitted to approve accounts.");
						cont=false;
					}
					
				}
			}
			
			
		}
		if(decision == 1)
		{
			System.out.println("Now taking you to ACCOUNT CREATION...");
			//GO TO CREATE NEW ACCOUNT
			UserInterface.CreateAccount(acctDAO);
		}
		
		
		System.out.println("Thank you for your business!");
		System.out.println("Goodbye.");
	}
}
