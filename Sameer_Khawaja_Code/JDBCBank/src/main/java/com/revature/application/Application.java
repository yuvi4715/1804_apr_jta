package com.revature.application;

import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.service.UserService;

public class Application {
	// Below are the core ones (everyone MUST accomplish them)
	// -account creation (admin and user role)
	// -admins must approve users before they can be used
	// -transactions, must support withdrawals and deposits
	// -must use logging
	// -everything must NOT be in the main method.
	// -data must be persisted
	// -collect data inputs from console

	// TODO
	// promote user to admin
	// implement deletion methods
	// change user information
	// make quit=0
	// add search users for admins
	// add overdraft fees for negative balance
	// handle invalid entry exception
	// admins can withdraw/deposit any account
	// make logs uniform with username first, followed by action
	// ability to diversify bonds
	
	final static Logger log = Logger.getLogger(Application.class);
	//factory, dao, singleton
	public static void main(String[] args) {
		User user = new User();
		Scanner reader = new Scanner(System.in);
		do {
			System.out.println("Welcome to Wu-Tang International Bank.\nEnter 1 to Login.\n"
					+ "Enter 2 to Create an Account. \nEnter 3 to Exit.");
			int input = reader.nextInt();
			if (input == 1) {// login
				String username = validLogin();// checks if username and password are valid
				if (username != null) {// null if username + password do not match
					user = UserService.userInfo(user, username);// create user object
					// System.out.println(user.toString());//debug
					bankMenu(user);
				}
			} else if (input == 2) {// create an account
				accountCreator(user);
				continue;
			} else if (input == 3) {// quot
				reader.close();
				System.out.println("Thank you for using Wu-Tang International Bank.\nGoodbye.");
				break;
			} else {
				System.out.println("Invalid input");
			}
		} while (true);

	}

	private static void bankMenu(User user) {
		// user
		// check if approved
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		if (user.getApproved() == 0) {// unapproved user
			System.out.println("Your account is locked. Please contact an administrator.");
			System.out.println("Reurning to main menu\n");
			// APPROVED USER
		} else if (user.getApproved() == 1 && user.getAdminPrivilege() == 0) {// approved user
			do {
				System.out.println("\nWelcome " + user.getFirstname() + ". What would you like to do today?");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Logout");
				int input = reader.nextInt();
				if (input == 1) {// check balance
					String accType = null;
					if (user.getAccountType().equals("c")) {
						accType = "Checking";
					} else if (user.getAccountType().equals("s")) {
						accType = "Savings";
					}

					System.out.println(
							accType + " account balance: " + UserService.checkBalance(user).getAccountBalance());
				} else if (input == 2) {
					double amount = 0;
					do {
						System.out.println("How much would you like to deposit today?");
						amount = reader.nextDouble();
						if (amount < 0) {
							System.out.println("Invalid amount.");
						} else {
							break;
						}
					} while (true);
					UserService.deposit(user, amount);
					System.out.println("Deposited: " + amount);
					System.out.println("Account balance: " + UserService.checkBalance(user).getAccountBalance());
					log.info("Deposit done by " + user.getUsername());
				} else if (input == 3) {
					double amount = 0;
					do {
						System.out.println("How much would you like to withdraw today?");
						amount = reader.nextDouble();
						if (amount < 0) {
							System.out.println("Invalid amount.");
						} else if (amount > UserService.checkBalance(user).getAccountBalance()) {
							log.info(user.getUsername() + " tried to withdraw with insufficient funds");
							System.out.println("Insufficient funds.");
						} else {
							break;
						}
					} while (true);

					UserService.withdraw(user, amount);
					System.out.println("Withdrew: " + amount);
					System.out.println("Account balance: " + UserService.checkBalance(user).getAccountBalance());
					log.info("Withdraw done by " + user.getUsername());

				} else if (input == 4) {
					System.out.println("Returning to the main menu.");
					log.info(user.getUsername() + " logged out.");
					System.out.println();
					break;
				} else {
					System.out.println("Invalid input.");
				}
			} while (true);
			// ADMIN
		} else if (user.getAdminPrivilege() == 1) {
			do {
				System.out.println("\nWelcome " + user.getFirstname() + ". What would you like to do today?");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Approve a user");
				System.out.println("5. Logout");
				int input = reader.nextInt();
				if (input == 1) {// check balance
					String accType = null;
					if (user.getAccountType().equals("c")) {
						accType = "Checking";
					} else if (user.getAccountType().equals("s")) {
						accType = "Savings";
					}

					System.out.println(
							accType + " account balance: " + UserService.checkBalance(user).getAccountBalance());
				} else if (input == 2) {
					double amount = 0;
					do {
						System.out.println("How much would you like to deposit today?");
						amount = reader.nextDouble();
						if (amount < 0) {
							System.out.println("Invalid amount.");
						} else {
							break;
						}
					} while (true);
					UserService.deposit(user, amount);
					System.out.println("Deposited: " + amount);
					System.out.println("Account balance: " + UserService.checkBalance(user).getAccountBalance());
					log.info("Deposit done by " + user.getUsername());
				} else if (input == 3) {
					double amount = 0;
					do {
						System.out.println("How much would you like to withdraw today?");
						amount = reader.nextDouble();
						if (amount < 0) {
							System.out.println("Invalid amount.");
						} else if (amount > UserService.checkBalance(user).getAccountBalance()) {
							log.info(user.getUsername() + " tried to withdraw with insufficient funds");
							System.out.println("Insufficient funds.");
						} else {
							break;
						}
					} while (true);
					UserService.withdraw(user, amount);
					System.out.println("Withdrew: " + amount);
					System.out.println("Account balance: " + UserService.checkBalance(user).getAccountBalance());
					log.info("Withdraw done by " + user.getUsername());
				} else if (input == 4) {
					System.out.println("Enter a username to approve.");
					String username = reader.next();
					if (UserService.approveUser(username)) {
						log.info(username + " approved by " + user.getUsername() + ".");
						System.out.println(username + " approved.");
					} else {
						System.out.println("Approved failed.");
					}

				} else if (input == 5) {
					System.out.println("Returning to the main menu.");
					log.info(user.getUsername() + " logged out.");
					System.out.println();
					break;
				} else {
					System.out.println("Invalid input.");
				}
			} while (true);

		}

	}

	private static void accountCreator(User user) {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		do {
			System.out.println("Enter your first name.");
			String first = reader.next();
			System.out.println("Enter your last name.");
			String last = reader.next();
			String username = null;
			do {
				System.out.println("Enter your username.");
				// check if username is taken
				username = reader.next();
				if (UserService.usernameTaken(username)) {
					System.out.println("Username is taken.");
				} else {
					break;
				}
			} while (true);
			System.out.println("Enter your password.");
			String password = reader.next();

			String accountType = null;

			do {
				System.out.println("Would you like to open a checking or savings account?");
				System.out.println("Enter 'c' for checking.");
				System.out.println("Enter 's' for saving.");
				accountType = reader.next();
				System.out.println(accountType);
				if (accountType.equals("c") || accountType.equals("s")) {
					break;
				} else {
					System.out.println("Invalid entry.");

				}
			} while (true);

			System.out.println("Is this information correct?");
			System.out.println("First name: " + first);// not checking for size
			System.out.println("Last name: " + last);// not checking for size
			System.out.println("Username: " + username);// not checking for size
			System.out.println("Password: " + password);// not checking for size
			System.out.println("Account Type: " + accountType);
			System.out.println("1. Yes.\n2. No"); // FIX
			int input = reader.nextInt();
			if (input == 1) {
				// add user to database
				Random rand = new Random();
				user = new User(username, password, first, last, 0, 0, rand.nextInt(1000000000), 0.0, accountType);
				UserService.insertUser(user);
				System.out.println("User '" + username + "' has been created.\n");
				break;
			} else if (input == 2)
				;

		} while (true);

	}

	private static String validLogin() {
		System.out.println("Enter your username: ");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		String username = reader.next();
		System.out.println("Enter your password: ");
		String password = reader.next();
		if (UserService.findUser(username, password)) {
			log.info(username + " logged in.");
			System.out.println("Login successful.");
			return username;
		} else {
			System.out.println("Invalid Username/Password.\n");
			return null;
		}

	}
	// User user = new User("master", "password", "John", "Doe", 1, 1, 123456789,
	// 1000000.50, "s");
	// System.out.println("User was inserted: " + UserService.insertUser(user));
	// System.out.println("User was deleted : " + UserService.deleteUser(user));
	// System.out.println("User deposited : " + UserService.deposit(user, 500));
	// System.out.println("User withdrew : " + UserService.withdraw(user,
	// 500));//need to check if balance is negative

}
