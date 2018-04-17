package com.revature.accountcreation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.banklogging.CuongIncLogging;
import com.revature.model.Administrator;
import com.revature.model.BankCustomer;
import com.revature.service.AdministratorService;
import com.revature.service.BankCustomerService;
import com.revature.service.Transactions;

//Class for signing into the bank application
public class SigningIn {
	final static Logger log = Logger.getLogger(CuongIncLogging.class);
	// Method called when administrator sign into account
	public static void adminLogin() {

		Scanner user = new Scanner(System.in);
		boolean toContinue = true;
		do {
			System.out.println("Please enter in your username: ");
			String testUsername = user.nextLine();
			System.out.println();
			Administrator newAdmin = AdministratorService.getAdmin(testUsername);
			System.out.println("Please enter in your password: ");
			String testPassword = user.nextLine();
			System.out.println();
			if (testUsername.equals(null)) {
				System.out.println("The username you provided does not currently exist.");
				System.out.println("Please try again.");
				System.out.println();
			}
			if (testPassword.equals(newAdmin.getPassword()) & testUsername.equals(newAdmin.getUsername())) {
				System.out.println("Successful login");
				System.out.println();
				log.info(newAdmin.getUsername() + " has logged in.");
				System.out.println();
				System.out.println("Please type in an account to activate: ");
				newAdmin.activateAccount();
				toContinue = false;
			}
				else
				System.out.println("The password/username you type in is incorrect. Please try again.");
			    System.out.println();
		} while (toContinue);
	}

	// Method called when bank customer sign into account
	public static void customerLogin() {
		Scanner user = new Scanner(System.in);
		boolean toContinue = true;
		do {
			System.out.println("Please enter in your username: ");
			String testUsername = user.nextLine();
			System.out.println();
			BankCustomer newLogin = BankCustomerService.getBankCustomer(testUsername);
			System.out.println("Please enter in your password: ");
			String testPassword = user.nextLine();
			System.out.println();
			if (testUsername.equals(null)) {
				System.out.println("The username you provided does not currently exist.");
				System.out.println("Please try again.");
				System.out.println();
			}
			if (testPassword.equals(newLogin.getPassword()) & testUsername.equals(newLogin.getUsername())) {
				System.out.println("Successful login");
				System.out.println();
				log.info(newLogin.getUsername() + " has logged in.");
				System.out.println();
				int testAccess = newLogin.getAccesslevel();
				if (testAccess == 0) {
					System.out.println();
					System.out.println("Your account has not been activated by an administrator yet.");
					System.out.println("Please wait for your account to be approved.");
					toContinue = false;
				}
				else if (testAccess == 1) {
					System.out.println();
					System.out.println("Welcome " + newLogin.getFirstName());
					System.out.println("You currently have $" + newLogin.getBalance() + " in your account.");
					System.out.println("What would you like to do?: ");
					System.out.println("(1) Withdraw");
					System.out.println("(2) Deposit");
					int choice = user.nextInt();
					if (choice == 1) {
						Transactions.Withdraw(newLogin);
					}
					
					else if (choice == 2) {
						Transactions.Deposit(newLogin);
					}
				}
				toContinue = false;
			} else
				System.out.println("The password/username you type in is incorrect. Please try again.");
			    System.out.println();
		} while (toContinue);
	}


	// Method called to interact with user to see if they want to login existing
	// account or create new account.
	public static void askAccountLogin() {
		int loginChoice = 0;
		int createChoice = 0;
		boolean toContinue = true;
		System.out.println("--------------------Welcome to Cuong's Banking Application-----------------");
		System.out.println();
		do {
			try {
				System.out.println("Create new account: (1)");
				System.out.println("Login to bank account: (2)");
				System.out.println("Login to admin account: (3)");
				Scanner user = new Scanner(System.in);
				loginChoice = user.nextInt();
				if (loginChoice == 1) {
					System.out.println();
					System.out.println("Creating a new account...");
					do {
						try {
							System.out.println("New admin account: (1)");
							System.out.println("New bank account: (2)");
							createChoice = user.nextInt();
							if (createChoice == 1) {
								System.out.println();
								System.out.println("Creating a new admin account...");
								AccountCreation.createAdmin();
								toContinue = false;
								break;
							} else if (createChoice == 2) {
								System.out.println();
								System.out.println("Creating a new bank account...");
								AccountCreation.createBankCustomer();
								toContinue = false;
								break;
							}
							else {
								System.out.println();
								System.err.println("Invalid choice, please try again.");
								user.reset();
								continue;
							}
						} catch (InputMismatchException ime) {
							System.err.println("Invalid input, please try again.");
						} catch (Exception e) {
							System.err.println("Invalid input, please try again.");
						}
					} while (toContinue == false);
				} else if (loginChoice == 2) {
					System.out.println();
					System.out.println("Logging into your account...");
					SigningIn.customerLogin();
					toContinue = false;
				} else if (loginChoice == 3) {
					System.out.println();
					System.out.println("Logging into your account...");
					SigningIn.adminLogin();
					toContinue = false;
				}
				
				else {
					System.err.println("Invalid choice, please try again.");
					user.reset();
					continue;
				}
			} catch (InputMismatchException ime) {
				System.err.println("Invalid input, please try again.");
			} catch (Exception e) {
				System.err.println("Invalid input, please try again.");
			}
		} while (toContinue);
	}
}
