package com.revature.bankingApp;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bankModel.Admin;
import com.revature.bankModel.Customer;
import com.revature.bankService.BankService;

public class ExecuteBank2 {

	final static Logger logger = Logger.getLogger(ExecuteBank2.class);
	
	public static void main(String[] args) {
		logger.info("Login Successful");
		logger.warn("Login Failed");
		logger.error("Error Printed");
		logger.debug("Debug Printed");
		
	}
	
	public static void startBank() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("=============================\n Welcome to the Goldenrod City Bank!\n"+"============================= ");
		loginOptions(userInput);
		
	}
	
	
	public static void loginOptions(Scanner userInput) {
		boolean userDecision = true;// It's simpler from true to false in switch although
									// it linguistically makes more sense going from false to true.
		System.out.println("Please enter number applicable to your needs:\n"+
				"1: User Login\n"+"2: Admin Login\n"+"3: Create New User\n"+"4: Create New Admin\n");

		String userIn = userInput.nextLine();
		while(userDecision){
			
			switch(userIn){
			case"1":{
				userDecision=false;
				System.out.println("Proceeding to User Login ");
				System.out.println("Enter username: ");
				String tempName = userInput.nextLine();
				System.out.println("Enter password: ");
				String tempPass = userInput.nextLine();
				Customer customer = BankService.loginCustomer(tempName, tempPass);
				if (customer == null) {
					System.out.println("Invalid username/password combination.");
					logger.warn("Login Failed");
					loginOptions(userInput);
				}else {
					System.out.println("Success");
					logger.info("Login Successful");
					customerScreen(customer, userInput);
					break;
				}
			}
	
			case"2":{
				System.out.println("Proceeding to Admin Login ");
				System.out.println("Enter username: ");
				String tempName = userInput.nextLine();
				System.out.println("Enter password: ");
				String tempPass = userInput.nextLine();
				Admin admin = BankService.loginAdmin(tempName, tempPass);
				if (admin == null) {
					logger.warn("Login Failed");
					System.out.println("Invalid username/password combination.");
					loginOptions(userInput);
				}else {
					System.out.println("Success");
					logger.info("Login Successful");
					adminScreen(admin, userInput);
					break;
				}
			}
		
			case"3":{
				System.out.println("Proceeding to Create New User");
				System.out.println("Enter desired username: ");
				String tempName = userInput.nextLine();
				System.out.println("Enter desired password: ");
				String tempPassword = userInput.nextLine();
				System.out.println("Enter first name: ");
				String tempFirstname = userInput.nextLine();
				System.out.println("Enter last name: ");
				String tempLastname = userInput.nextLine();
				Customer customer = new Customer(tempName, tempPassword, tempFirstname, tempLastname);
				if(BankService.createCustomer(customer) == true) {
				System.out.println("Welcome to the Goldenrod Bank! We hope we enjoy your stay. \nHowever,"
						+ "in order to proceed with our services, your account must first be approved by an admin. \nPlease contact"
						+ "hr@goldenrod.com if your account is not activated within 3 business days.\n");
				logger.info("User Created");
				}else {
					logger.warn("Account Creation Failed");
					System.out.println("Either your account name was taken or there was an error with our systems.\n Please "
							+ "try again with a different account name.\n");
					loginOptions(userInput);
				}
				userDecision=false;
				break;
			}
			case"4":{
				System.out.println("Proceeding to Create New Admin");
				System.out.println("Enter desired username: ");
				String tempName = userInput.nextLine();
				System.out.println("Enter desired password: ");
				String tempPassword = userInput.nextLine();
				System.out.println("Enter first name: ");
				String tempFirstname = userInput.nextLine();
				System.out.println("Enter last name: ");
				String tempLastname = userInput.nextLine();
				System.out.println("Enter admin code: ");
				String adminCode = userInput.nextLine();	
				if (adminCode.equals("blacksheepwall")) {
					Admin admin = new Admin(tempName, tempPassword, tempFirstname, tempLastname);
					if(BankService.createAdmin(admin) == true) {
					System.out.println("Welcome to the Goldenrod Bank! We hope we enjoy your stay.");
					logger.info("Admin Created");
					}else {
						logger.warn("Admin Creation Failed");
						System.out.println("Either your account name was taken or there was an error with our systems. Please "
								+ "try again with a different account name.\n");
					}
					loginOptions(userInput);
				}
				System.out.println("Wrong code. Returning back to main screen.\n");
				userDecision=false;
				loginOptions(userInput);
				break;

			}
			default:{
				System.out.println("Wrong input. Please try again.\n");
				userIn=userInput.nextLine();
			}
			}
		}
	}
	
	public static void customerScreen(Customer customer, Scanner userInput) {
		System.out.println("=========== " + customer.getFirstName()+ ", welcome "
				+ "back to your Account Management Screen."+"=========== \n");

		if (BankService.checkVerified(customer) == false) {
			System.out.println("Your account is not yet verified.");
			userInput.close();
			System.exit(0);
		}
		customerChoices(customer, userInput);
	}
	
	public static void customerChoices(Customer customer, Scanner userInput) {
		
		boolean userDecision = true;
			System.out.println("Enter number applicable to your needs:\n"+
				"1: View Account Balances\n"+"2: Create Account\n"+ "3: Add or Withdraw from Account\n" + 
					"4: View Account Transactions\n" + "5: Exit Online Bank\n");
			String userIn = userInput.nextLine();
			
			while(userDecision){
			
				switch(userIn){
					case"1":{
						BankService.checkAccountBalance(customer);
						System.out.println("");
						customerChoices(customer, userInput);
					
					}case"2":{
						if (BankService.createAccount(customer, userInput)) {
							System.out.println("New bank account successfully created.\n");
							logger.info("Bank Account for " + customer.getUserName()+ " created.");

						}else {
							System.out.println("Something went wrong. Please try again with a different account name.\n");
							logger.info(customer.getUserName()+ " failed to create an account.");

						}
						customerChoices(customer, userInput);
						
					}case"3":{
						System.out.println("Enter account you wish to add funds to: ");
						String tempAcctNum = userInput.nextLine();
						int acctNum = 0;
						BigDecimal changeBalance = new BigDecimal(0);
					    try{
					    	acctNum = Integer.parseInt(tempAcctNum);
					    }catch (NumberFormatException ex){
					    	System.out.println("Not a valid account number.\n");
					    	customerChoices(customer, userInput);
					    }
					    if (BankService.enforceAccount(customer, acctNum) == false) {
					    	logger.warn(customer.getUserName() + " has tried to access another's account.");
					    	System.out.println("This account does not belong to you.\n");
					    	customerChoices(customer, userInput);
					    }
					    System.out.println("How much would you like to add/withdrawl to your account?\n");
						String tempBalance = userInput.nextLine();
					    try{
					    	changeBalance = new BigDecimal(Long.parseLong(tempBalance));
					    }catch (NumberFormatException ex){
					    	System.out.println("Not a valid transaction amount.\n");
					    	customerChoices(customer, userInput);
					    }
					    if (BankService.checkBalance(acctNum, changeBalance) == false) {
					    	System.out.println("Invalid transaction. Withdrawl exceeds total balance.\n");
					    	customerChoices(customer, userInput);
					    }
					    BankService.addTransaction(acctNum, changeBalance);
					    
						customerChoices(customer, userInput);		
						
					}case"4":{
						System.out.println("Enter account whose transactions you wish to check.\n");
						String tempAcctNum = userInput.nextLine();
						int acctNum = 0;
						
					    try{
					    	acctNum = Integer.parseInt(tempAcctNum);
					    }catch (NumberFormatException ex){
					    	System.out.println("Not a valid account number.\n");
					    	customerChoices(customer, userInput);
					    }
					    
					    if (BankService.enforceAccount(customer, acctNum) == false) {
					    	logger.warn(customer.getUserName() + " has tried to access another's account.");
					    	System.out.println("This account does not belong to you.\n");
					    	customerChoices(customer, userInput);
					    }
					    BankService.viewAccountTransactions(acctNum);
						customerChoices(customer, userInput);		

					
					}case"5":{
						System.out.println("Logged out successfully.\n");
						userInput.close();
						System.exit(0);
						
					}default:{
						System.out.println("Wrong input. Please try again.\n");
						customerChoices(customer, userInput);
					}
				}
			}
	}

	public static void adminScreen(Admin admin, Scanner userInput) {
		System.out.println("=========== " + admin.getFirstName()+ ", welcome "
				+ "back to your Admin Management Screen."+"=========== \n");
		adminChoices(admin, userInput);
	}
	
	public static void adminChoices(Admin admin, Scanner userInput) {
		System.out.println("Please enter number applicable to your needs:\n"+
				"1: Show All Customers\n"+"2: Approve Customer\n"+"3: Logout");

		String userIn = userInput.nextLine();
		while(true){
			switch(userIn) {
			
			case"1":{
				BankService.getAllCustomers();
				adminChoices(admin,userInput);
				break;
			
			}case"2":{
				BankService.approveUser(userInput);
				adminChoices(admin,userInput);
				break;
			}case"3":{
				System.out.println("Logged out successfully.\n");
				userInput.close();
				System.exit(0);
			}
			default:{
				System.out.println("Wrong input. Please try again.\n");
				userIn=userInput.nextLine();
			}
			
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
}
