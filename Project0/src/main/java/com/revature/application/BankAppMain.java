package com.revature.application;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Model.Bank;
import com.revature.service.BankService;
// Class serves as the application that allows a user to use the Bank Service.  Program will continue to run until user logs out and exits application.
public class BankAppMain {
	
	Bank currentUser = null;
	Scanner k = new Scanner(System.in);
	final static Logger log = Logger.getLogger(BankAppMain.class);
	
	
	// Constructor
	public BankAppMain() {
		log.info("User has started application");
		System.out.println("Welcome to Keepin' it Real Bank! Where that is all we do!");
		mainMenu();
		k.close();
	}
	
	// Menu strictly allowed to admins, if user tries to access it, they will be denied.
	public void adminMenu() { // Menu ONLY for admins
		log.info("User " + currentUser.getUserName() + " has attempted to log in as an admin");
		int choice = 0;
		if (currentUser.getPrivilege().equals("admin")) {
			log.info("Admin log in is successful.");
			System.out.println("Welcome to the admin main menu " + currentUser.getFirstName() + " !");
			System.out.println("What would you like to do?");
			System.out.println();
			int amount;
			String userSelection = null;
			boolean operation = false;
			do {
				System.out.println("Enter 1: To deposit cash into checking account");
				System.out.println("Enter 2: To withdraw cash from checking account");
				System.out.println("Enter 3: To deposit cash into savings account");
				System.out.println("Enter 4: To withdraw cash from savings account");
				System.out.println("Enter 5: To Approve a new user.");
				System.out.println("Enter 6: To retrieve all users in the Database.");
				System.out.println("Enter 7: Create a new user or admin account.");
				System.out.println("Enter 8: Delete an account.");
				System.out.println("Enter 9: To log out");
				choice = k.nextInt();
				switch (choice) {
				case 1 :
					System.out.println("Enter amount to deposit into checking.");
					amount = k.nextInt();
					if (BankService.depositChecking(currentUser, amount)) {
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Deposit successful. New balance is:" + currentUser.getCheckingBalance());
						log.info("Admin deposited money into checking account");
						break;
					} else {
						System.out.println("An error occurred, please try again");
						log.error("Admin failed to deposit money into checking account");
						break;
					}
				case 2 :
					System.out.println("Enter amount to withdraw from checking.");
					amount = k.nextInt();
					if (currentUser.getCheckingBalance() - amount >= 0) {
						BankService.withdrawChecking(currentUser, amount);
						log.info("Admin withdrew money from checking account");
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Withdraw successful. New balance is: " + currentUser.getCheckingBalance());
						break;
					} else {
						
						System.out.println("An error occurred or insufficient funds. Please try again");
						log.error("Admin failed to withdraw money from checking account");
						break;
					}
					
				case 3:
					System.out.println("Enter amount to deposit into savings.");
					amount = k.nextInt();
					if (BankService.depositSavings(currentUser, amount)) {
						currentUser = BankService.getBankUser(currentUser.getUserName());
						log.info("Admin deposited money from savings account");
						System.out.println("Deposit successful. New balance is: " + currentUser.getSavingBalance());
						break;
					} else {
						System.out.println("An error occurred, please try again");
						log.error("Admin failed to deposit money into savings account");
						break;
					}
				
				case 4 :
					System.out.println("Enter amount to withdraw from savings.");
					amount = k.nextInt();
					if (currentUser.getSavingBalance() - amount >= 0) {
						BankService.withdrawSavings(currentUser, amount);
						log.info("Admin withdrew money from savings account");
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Withdraw  New balance is: " + currentUser.getSavingBalance());
						break;
					} else {
						System.out.println("An error occurred or insufficient funds. Please try again");
						log.error("Admin failed to withdraw money from savings account");
						break;
						
					}
				case 5 :
					System.out.println("You have selected to approve a new user, please enter the username of the user to be approved.");
					userSelection = k.next();
					if (BankService.validateUser(userSelection)) {
						log.info("Admin attemps to approve user");
						System.out.println("User " + userSelection + " has been approved");
						break;
					}
					else {
						log.error("Approval fails");
						System.out.println("Error, user does not exist or something went wrong. Try again.");
					}
					break;
				
				case 6 :
					System.out.println("Showing all users in database, including yourself...");
					List<Bank> users = BankService.getAllBankers();
					log.info("Admin requests all users in database");
					for (Bank b : users) {
						System.out.println(b);
					}
					System.out.println();
					System.out.println("Enter any character to continue.");
					String cont = k.next(); // halts until user inputs something, nothing else
					System.out.println();
					System.out.println();
					System.out.println();
					break;
				
				case 7 :
					log.info("Admin creates a new user or admin");
					BankService.adminInsertBanker();
					break;
				
				case 8 :
					log.info("Admin begins to delete an account");
					System.out.println("You have elected to delete a user, enter the username of the account you wish to delete.");
					System.out.println("Remember that you cannot delete the owner of the database or yourself. Admins can only be deleted by the owner.");
					userSelection = k.next();
					if (userSelection != "Harty777" && userSelection != currentUser.getUserName()) {
							BankService.deleteBanker(userSelection);
							System.out.println("Bank account with the username "+ userSelection + " has been deleted.");
					}else {
						log.error("Admin requested to delete a user that does not exist.");
						System.out.println("An error has occurred. Either selection was not authorized or selection does not exist.");
					}
					break;
					
				case 9 :
					System.out.println("Logging you out.");
					log.info("Admin logs out.");
					currentUser = null;
					operation = true;
					break;
				
				default :
					System.out.println("Incorrect choice, try again.");
					
					
				}// switch end
			}while (operation == false);
		
		} else {//end of if statement
			System.out.println("Error: Access Denied. Logging you out...");
			currentUser = null;
		}
	}
	
	
	// user menu, set for normal users. If user is an admin, they are required to use admin menu.
	public void userMenu() { // Menu for normal users
		log.info("User menu entered");
		System.out.println(currentUser.getIsApproved());
		String approved = "false";
		if (currentUser.getIsApproved().equals(null)) {
			approved = "true";
		} else if (currentUser.getIsApproved().equals("true")) {
			approved = "true";
		}
		if (approved.equals("true")) {
			log.info("User menu accessed");
			int choice = 0;
			System.out.println("Welcome to the user menu " + currentUser.getFirstName() + " !");
			System.out.println("What would you like to do?");
			System.out.println();
			int amount;
			boolean operation = false;
			do {
				if (currentUser.getPrivilege().equals("admin")) {
					System.out.println("Sorry, but you are an admin - please log in as one!");
					operation = true;
					log.warn("User turned out to be an admin, heading back to main menu.");
					break;
				}
				System.out.println("Enter 1: To deposit cash into checking account");
				System.out.println("Enter 2: To withdraw cash from checking account");
				System.out.println("Enter 3: To deposit cash into savings account");
				System.out.println("Enter 4: To withdraw cash from savings account");
				System.out.println("Enter 5: To log out");
				choice = k.nextInt();
				switch (choice) {
				case 1 :
					log.info("User attempts to deposit cash into checking");
					System.out.println("Enter amount to deposit into checking.");
					amount = k.nextInt();
					if (BankService.depositChecking(currentUser, amount)) {
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Deposit successful. New balance is:" + currentUser.getCheckingBalance());
						break;
					} else {
						System.out.println("An error occurred, please try again");
						break;
					}
				case 2 :
					log.info("User attempts to withdraw from checking");
					System.out.println("Enter amount to withdraw from checking.");
					amount = k.nextInt();
					if (currentUser.getCheckingBalance() - amount >= 0) {
						BankService.withdrawChecking(currentUser, amount);
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Withdraw successful. New balance is: " + currentUser.getCheckingBalance());
						break;
					} else {
						System.out.println("An error occurred or insufficient funds. Please try again");
						break;
					}
					
				case 3:
					log.info("User attempts to deposit cash into savings");
					System.out.println("Enter amount to deposit into savings.");
					amount = k.nextInt();
					if (BankService.depositSavings(currentUser, amount)) {
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Deposit successful. New balance is: " + currentUser.getSavingBalance());
						break;
					} else {
						System.out.println("An error occurred, please try again");
						break;
					}
				
				case 4 :
					log.info("User attempts to withdraw from savings");
					System.out.println("Enter amount to withdraw from savings.");
					amount = k.nextInt();
					if (currentUser.getSavingBalance() - amount >= 0) {
						BankService.withdrawSavings(currentUser, amount);
						currentUser = BankService.getBankUser(currentUser.getUserName());
						System.out.println("Withdraw  New balance is: " + currentUser.getSavingBalance());
						break;
					} else {
						System.out.println("An error occurred or insufficient funds. Please try again");
						break;
					}
				case 5:
					log.info("User Logs out.");
					System.out.println("Logging you out!");
					currentUser = null;
					operation = true;
					break;
				
				default :
					System.out.println("Incorrect input, please try again");
				} // end of switch
			}while (operation == false);
			
		} else {
			log.info("User log in procedure fails to validate user or user is an admin.");
			System.out.println("We are sorry, but your account has not been approved yet.");
			System.out.println("Please wait for your account to be approved by an administrator.");
			System.out.println("Otherwise you are an admin and should be using this log on procedure.");
			System.out.println("Logging you out...");
			currentUser = null;
	
		}
		
	}
	
	
	//The main menu of the Bank
	public void mainMenu() { // Page requesting log in
		log.info("Main menu launched.");
		int option = 0;
		boolean mainOperation = true;
		String entry1;
		String entry2;
		do {
			System.out.println("Main Menu");
			System.out.println();
			System.out.println("What do you wish to do?");
			System.out.println("1: Log in as a user.");
			System.out.println("2: Log in as an admin.");
			System.out.println("3: Create an account.");
			System.out.println("4: Exit Application.");
			option = k.nextInt();
			switch (option) {
			case 1 :
				log.info("Log in as user selected");
				System.out.println("Enter your username.");
				entry1 = k.next();
				System.out.println("Enter your password");
				entry2 = k.next();
				if (BankService.logOn(entry1, entry2)) {
					currentUser = BankService.getBankUser(entry1);
					userMenu();
					
				} else {// end of first if statement
					System.out.println("Invalid credentials");
				}
				break;
			case 2 :
				log.info("Log in as admin selected");
				System.out.println("Enter your username.");
				entry1 = k.next();
				System.out.println("Enter your password");
				entry2 = k.next();
				if (BankService.logOn(entry1, entry2)) {
					currentUser = BankService.getBankUser(entry1);
					adminMenu();
					
				} else {
					System.out.println("Invalid credentials");
				}
				break;
			case 3 :
				log.info("Operation to create a new user is selected");
				BankService.userInsertBanker();
				break;
			
			case 4 :
				log.info("Application is being exited");
				System.out.println("Exiting application, thank you for your business!");
				mainOperation = false;
				break;
				
			
			default :
				System.out.println("Invalid input, please try again.");
			}
			
		} while (mainOperation == true);
	}
	
	public static void main(String[] args) {
		BankAppMain t = new BankAppMain();
	}
	
}
