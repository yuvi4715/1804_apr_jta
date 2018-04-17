package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil;

public class BankMenu {

	public static BankMenu instance = null;
	private Scanner input;
	final static Logger log = Logger.getLogger(BankMenu.class);
	
	
	// Private constructor for singleton class
	private BankMenu() {
		
		input = new Scanner(System.in);
	}
	
	// Create singleton instance of BankMenu
	public static BankMenu getInstance() {
		
		if (instance == null) {
			instance = new BankMenu();
		}
		
		return instance;
	}
	
	// Method that represents the welcome page of the app
	public void startApp() {
		
		//log.info("***Application Start***");
		
		System.out.println("Welcome to Revature Banking App!");
		System.out.println("\nEnter 1 to Login");
		System.out.println("Enter 2 to Create a new account");
		System.out.println("Enter anything else to quit");
		
		
		int menuChoice = 0;
		
		try {
			menuChoice = input.nextInt();
		} catch (InputMismatchException e) {
			
		}
		
		
		if (menuChoice == 1) {
			login();
		} else if (menuChoice == 2) {
			createNewAccount();
		} else {
			System.out.println("***Quitting application***");
		}
	}
	
	// Method that represents a menu page for creating a new account
	public void createNewAccount() {
		System.out.println("Create New Account: ");
		System.out.println("Enter a new username or 'q' to quit: ");
		
		
		String newUsername = "";
		String newPassword = "";
		String newFirstName = "";
		String newLastName = "";
		
		try {
			newUsername = input.next();
		} catch (InputMismatchException e) {
			
			System.out.println("\nPlease enter a valid username...\n");
			createNewAccount();
		}
		
		if (!newUsername.equals("q") && !newUsername.equals("")) {
			
			try (Connection conn = ConnectionUtil.getConnection()) {
				
				
				// Create a Statement Object
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE "
						+ "username='" + newUsername + "'");
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					System.out.println("Sorry, this username is already in use please try again...");
					createNewAccount();
				} else {
					
					System.out.println("Enter a new password for this user: ");
					newPassword = input.next();
					System.out.println("Enter First Name:");
					newFirstName = input.next();
					System.out.println("Enter Last Name:");
					newLastName = input.next();
					
					int index = 0;
					
					CallableStatement callableStmt = conn.prepareCall("{CALL insert_bank_user(?, ?, ?, ?, ?, ?, ?)}");
					callableStmt.setString(++index, newUsername);
					callableStmt.setString(++index, newPassword);
					callableStmt.setString(++index, newFirstName);
					callableStmt.setString(++index, newLastName);
					callableStmt.setInt(++index, 0);
					callableStmt.setInt(++index, 0);
					callableStmt.setDouble(++index, 0.0);
					
					callableStmt.executeUpdate();
					
					System.out.println("New user, " + newUsername + " successfully created.");
					log.info("***New user, " + newUsername + " has been created***");
					startApp();
				}
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
			}
		} else {
			startApp();
		}
		
		
	}
	
	// Method that will allow the user to login to his or her account
	public void login() {
		
		String username = "";
		String password = "";
		String actualPassword =  "";
		String firstName = "";
		String lastName = "";
		boolean isAdmin = false;
		boolean isActivated = false;
		double balance = 0.0;
		
		System.out.println("Enter username:");
		username = input.next();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// Create a Statement Object
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE "
					+ "username='" + username + "'");
			
			ResultSet rs = stmt.executeQuery();
			
			if (!rs.next()) {
				System.out.println("This username does not exist, please try again...");
				login();
			} else {
				actualPassword = rs.getString(3);
				
				System.out.println("Enter password:");
				password = input.next();
				
				while (!password.equals(actualPassword)) {
					System.out.println("Wrong password, please try again or 'q' to quit:");
					password = input.next();
					
					if (password.equals("q")) {
						startApp();
						break;
					}
				}
				
				firstName = rs.getString("firstname");
				lastName = rs.getString("lastname");
				balance = rs.getDouble("balance");
				isAdmin = rs.getInt("is_admin") > 0;
				isActivated = rs.getInt("is_activated") > 0;
				
				User currUser = new User(username, firstName, lastName, isAdmin, isActivated, balance);
				
				
				
				if (isAdmin) {
					log.info("***" + username + " has been logged in***");
					adminMenu(currUser);
				}else  if (isActivated){
					log.info("***" + username + " has been logged in***");
					userMenu(currUser);
				} else {
					System.out.println("This user has not yet been activated...\n");
					startApp();
				}
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error Code: " + e.getErrorCode());
		}
	}
	
	public void adminMenu(User user) {
		
		String targetUsername = "";
		String choice = "";
		
		System.out.println("Enter the username of the account you would like to modify,\n 'u' to "
				+ "access normal user menu or 'q' to quit:");
		targetUsername = input.next();
		
		// If user wants to quit
		if (targetUsername.equals("q")) {
			
			log.info("***" + user.getUsername() + " has been logged out***");
			startApp();
		} else if (targetUsername.equals("u")) {
			
			userMenu(user);
		} else {
		
			
			// If user doesn't want to quit
			try (Connection conn = ConnectionUtil.getConnection()) {
			
				// Create a Statement Object
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE "
						+ "username='" + targetUsername + "'");
				
				ResultSet rs = stmt.executeQuery();
				
				if (!rs.next()) {
					System.out.println("This username does not exist, please try again...");
					adminMenu(user);
				} else {
					
					System.out.println("Enter 1 if you would like to activate this account, "
							+ "2 if you would like to deactivate it, \n3 if you would like to "
							+ "promote to admin or 4 if you would like to revoke admin:");
					System.out.println("(any other input will logout and quit to main menu)");
					
					choice = input.next();
					
					if (choice.equals("1")) {
						if (UserService.activate(targetUsername)) {
							log.info("***" + targetUsername + " has been activated***");
						}
						
						adminMenu(user);
					} else if (choice.equals("2")) {
						if (UserService.deactivate(targetUsername)) {
							log.info("***" + targetUsername + " has been deactivated***");
						}
						
						adminMenu(user);
					} else if (choice.equals("3")) {
						if (UserService.promoteAdmin(targetUsername)) {
							log.info("***" + targetUsername + " has been granted admin***");
						}
						
						adminMenu(user);
					} else if (choice.equals("4")){
						if (UserService.revokeAdmin(targetUsername)) {
							log.info("***" + targetUsername + " has had admin priveledges revoked***");
						}
						
						adminMenu(user);				
					} else {
						log.info("***" + user.getUsername() + " has been logged out***");
						startApp();
					}
				}
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				System.err.println("SQL State: " + e.getSQLState());
				System.err.println("Error Code: " + e.getErrorCode());
			}
		}
		
	}
	
	public void userMenu(User user) {
	
		String choice = "";
		double amount = 0.0;
		
		System.out.println("Enter 1 to deposit money, 2 to withdraw money, 3 to check balance or anything else to quit:");
		choice = input.next();
		
		if (choice.equals("1")) {
			
			System.out.println("How much would you like to deposit?");
			amount = input.nextDouble();
			
			if (amount < 0) {
				
				System.out.println("Please enter a positive amount next time...");
				userMenu(user);
			} else {
				
				user = UserService.deposit(user, amount);
				
				log.info("***" + amount + " has been deposited into " + user.getUsername() + "'s account***");
				
				userMenu(user);
			}
		} else if (choice.equals("2")) {
			
			System.out.println("How much would you like to withdraw?");
			amount = input.nextDouble();
			
			if (amount < 0) {
				
				System.out.println("Please enter a positive amount next time...");
				userMenu(user);
			} else if (amount > user.getBalance()) {
				
				System.out.println("You do not have enough money in your account to withdraw that much...");
				userMenu(user);
			} else {
				
				user = UserService.withdraw(user, amount);
				
				log.info("***" + amount + " has been withdrawn from " + user.getUsername() + "'s account***");
				
				
				userMenu(user);
			}
		} else if (choice.equals("3")) {
			
			System.out.println(String.format("Your current balance is $%.2f", user.getBalance()));
			userMenu(user);
		} else {
		

			log.info("***" + user.getUsername() + " has been logged out***");
			startApp();
		}
	}
	
	public void exitApp() {
		input.close();
		instance = null;
	}		
}
	
	
