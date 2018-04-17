package com.revature.accountcreation;

import java.util.InputMismatchException;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.banklogging.CuongIncLogging;
import com.revature.model.Administrator;
import com.revature.model.BankCustomer;
import com.revature.service.AdministratorService;
import com.revature.service.BankCustomerService;

//Class for account creation
public class AccountCreation {
	final static Logger log = Logger.getLogger(CuongIncLogging.class);
	
//Method to make a new Bank Customer
	public static void createBankCustomer() {

		String accountType = AccountCreation.createAccountType();
		String firstName = AccountCreation.createFirstName();
		String lastName = AccountCreation.createLastName();
		String userName = AccountCreation.createUserName();
		String password = AccountCreation.createPassword();
		BankCustomer inputCustomer = new BankCustomer(accountType, firstName, lastName, userName, password, 0, 0);
		System.out.println();
		System.out.println("Here is a summary of your newly created account: ");
		System.out.println("Account Type: " + accountType);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("Welcome to CuongInc, " + firstName + "!");
		BankCustomerService.insertBankCustomer(inputCustomer);
		System.out.println();
		log.info("A new customer account was made: " + inputCustomer.getUsername() + ".");
		System.out.println();
		System.out.println(firstName + ", please wait for an administrator to activate your account.");
	}

//Method to set up Account Type for Bank Customers
	public static String createAccountType() {
		String accountType = null;
		boolean toContinue = true;
		do {
			try {

				System.out.println("Thank you for choosing CuongInc as your designated Bank!");
				System.out.println("What type of account would you like to set up?");
				System.out.println("--Checking");
				System.out.println("--Saving");
				System.out.println("--Credit");
				Scanner user = new Scanner(System.in);
				accountType = user.nextLine();
				if (accountType.equalsIgnoreCase("Checking")) {
					System.out.println();
					System.out.println("Creating a checking account...");
					toContinue = false;
				} else if (accountType.equalsIgnoreCase("Saving")) {
					System.out.println();
					System.out.println("Creating a saving account...");
					toContinue = false;
				} else if (accountType.equalsIgnoreCase("Credit")) {
					System.out.println();
					System.out.println("Creating a credit account...");
					toContinue = false;
				} else {
					System.out.println();
					System.err.println("Invalid input, please try again.");
					user.reset();
					continue;
				}
			} catch (InputMismatchException ime) {
				System.err.println("Invalid input, please try again.");
			} catch (Exception e) {
				System.err.println("Invalid input, please try again.");
			}
		} while (toContinue);
		return accountType;
	}
	
//Method to set a First Name 
	public static String createFirstName() {
		String firstName = null;
		boolean toContinue = true;
		do {
			try {
				System.out.println("What is your first name?");
				Scanner user = new Scanner(System.in);
				firstName = user.nextLine();
				System.out.println();
				System.out.println("Hello: " + firstName +"!");
				System.out.println();
				toContinue = false;
			} catch (InputMismatchException ime) {
				System.err.println("Invalid input, please try again.");
			} catch (Exception e) {
				System.err.println("Invalid input, please try again.");
			}
		} while (toContinue);
		return firstName;
	}

//Method to set a Last Name 
		public static String createLastName() {
			String lastName = null;
			boolean toContinue = true;
			do {
				try {
					System.out.println("What is your last name?: ");
					Scanner user = new Scanner(System.in);
					lastName = user.nextLine();
					System.out.println();
					toContinue = false;
				} catch (InputMismatchException ime) {
					System.err.println("Invalid input, please try again.");
				} catch (Exception e) {
					System.err.println("Invalid input, please try again.");
				}
			} while (toContinue);
			return lastName;
		}

//Method to set a user name
		public static String createUserName() {
			String userName = null;
			System.out.println("What is your username?: ");
			boolean toContinue = true;
			do {
				try {
					Scanner user = new Scanner(System.in);
					userName = user.nextLine();
					System.out.println();
					toContinue = false;
				} catch (InputMismatchException ime) {
					System.err.println("Invalid input, please try again.");
				} catch (Exception e) {
					System.err.println("Invalid input, please try again.");
				}
			} while (toContinue);
			return userName;
		}
		
//Method to set a password
		public static String createPassword() {
			String password = null;
			boolean toContinue = true;
			do {
				try {
					Scanner user = new Scanner(System.in);
					System.out.println("What is your password?: ");
					password = user.nextLine();
					System.out.println();
					toContinue = false;
				} catch (InputMismatchException ime) {
					System.err.println("Invalid input, please try again.");
				} catch (Exception e) {
					System.err.println("Invalid input, please try again.");
				}
			} while (toContinue);
			return password;
		}
			
//Method to create a new Administrator
	public static void createAdmin() {
		String firstName = AccountCreation.createFirstName();
		String lastName = AccountCreation.createLastName();
		String userName = AccountCreation.createUserName();
		String password = AccountCreation.createPassword();
		Administrator inputAdmin = new Administrator( firstName, lastName, userName, password);
		System.out.println();
		System.out.println("Here is a summary of your newly created account: ");
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("username: " + userName);
		System.out.println("password: " + password);
		System.out.println("Welcome to CuongInc, " + firstName + "!");
		AdministratorService.insertAdmin(inputAdmin);
		System.out.println();
		log.info("A new admin account was made: " + inputAdmin.getUsername() + ".");
		System.out.println();
	}
}
