//John Eifert
package accounts;

import java.util.Scanner;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import dao.AccountDAOImpl;



public class AdminAccount extends Account
{
	final static Logger logger = Logger.getLogger(AdminAccount.class);
	
	public AdminAccount(String h, String p, long a, int app)
	{
		this.holder = h;
		this.password = p;
		this.acctNumber = a;
		this.approved = app;
	}
	
	
	public boolean approveAccount(UserAccount account, AccountDAOImpl DAO)
	{
		logger.info("Beginning the user account approval process...");
		
		if(account.getBalance() != 0)
		{
			System.out.println("This user account is attempting to have a nonzero balance before approval.");
			logger.info("This user account is attempting to have a nonzero balance before approval.");
			System.out.println("The account in question will now be auto-denied.");
			logger.info("The account in question will now be auto-denied.");
			return(false);
		}
		
		logger.info("The account in question is a USER account.");
		System.out.println("Account holder = " + account.getHolder());
		logger.info("Account holder = " + account.getHolder());
		System.out.println("Account number = " + account.getAcctNumber());
		logger.info("Account number = " + account.getAcctNumber());
		
		Scanner in = new Scanner(System.in);
		
		boolean isValid=false;
		String input;
		int intInput=0;
		while(!isValid)
		{
			System.out.println("Are you sure that you want to approve this USER account?");
			System.out.println("Enter 1 for yes, enter 2 for no:");
			try
			{
				input=in.nextLine();
				intInput=Integer.parseInt(input);
				if(intInput == 1 || intInput == 2)
				{
					isValid=true;
					break;
				}
				System.out.println("You have entered an invalid option number.  Please try again.");
			}
			catch(Exception e)
			{
				isValid=false;
				System.out.println(e.getMessage());
				System.out.println("There was a problem reading your option number.  Please try again.");
			}
		}
		
		if(intInput == 1)
		{
			System.out.println("The account will now be approved.");
			logger.info("The account will now be approved.");
			
			
			
			return(true);
		}
		System.out.println("The account will now be denied.");
		logger.info("The account will now be denied");
		return(false);
	}
	
	
	public void presentApprovals(AccountDAOImpl DAO)
	{
		System.out.println("Now presenting unapproved accounts...");
		logger.info("Now presenting unapproved accounts...");
		
		ArrayList<UserAccount> userAccts = DAO.getAllUserAccounts();
		ArrayList<AdminAccount> adminAccts = DAO.getAllAdminAccounts();
		
		System.out.println("Unapproved User Accounts:");
		for(int i=0; i<userAccts.size(); i++)
		{
			if(userAccts.get(i).getApproved() != 1)
			{
				System.out.print("Account Number: " + userAccts.get(i).getAcctNumber());
				System.out.print(", Name: " + userAccts.get(i).getHolder());
				System.out.print(", Balance: " + userAccts.get(i).getBalance() + "\n");
			}
		}
		
		System.out.println("Unapproved Admin Accounts:");
		for(int i=0; i<adminAccts.size(); i++)
		{
			if(adminAccts.get(i).getApproved() != 1)
			{
				System.out.print("Account Number: " + adminAccts.get(i).getAcctNumber());
				System.out.print(", Name: " + adminAccts.get(i).getHolder());
			}
		}
		
		logger.info("Finished presenting unapproved accounts.");
	}
	
}
