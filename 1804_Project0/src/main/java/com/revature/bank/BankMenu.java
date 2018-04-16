package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

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
		
		System.out.println("Welcome to Revature Banking App!");
		System.out.println("\nEnter 1 to Login");
		System.out.println("Enter 2 to Create a new account:");
		
		
		int menuChoice = 0;
		
		try {
			menuChoice = input.nextInt();
		} catch (InputMismatchException e) {
			
			System.out.println("\nPlease enter a valid choice next time...\n");
		}
		
		
		if (menuChoice == 1) {
			login();
		} else if (menuChoice == 2) {
			createNewAccount();
		} else {
			System.out.println("Please enter a valid choice next time...\n");
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
					
					System.out.println("New user, " + newUsername + " successfully created...");
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
	
	public void login() {
		
	}
	
	public void exitApp() {
		log.info("Test exit log");
		input.close();
		instance = null;
	}		
}
	
	
