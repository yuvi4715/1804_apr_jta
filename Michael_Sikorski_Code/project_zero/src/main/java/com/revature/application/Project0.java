package com.revature.application;

import java.sql.*;
import java.util.*;
import org.apache.log4j.Logger;

import com.revature.model.Admin;
import com.revature.model.Client;
import com.revature.model.User;

public class Project0 {

	private static final Logger log = Logger.getLogger(Project0.class);
	private static Scanner in = new Scanner(System.in);
	private static User u;
	private static ArrayList<String> displayOptions;
	
	public static void main(String[] args) {
		log.info("Application has been initialized: ");
		initialize();
	}

	/**
	 *  The initialize method displays the application's 
	 *  title screen and calls the initialPrompt method
	 */
	private static void initialize() {
		System.out.println("    -- Welcome to Michael Sikorski's Banking App --");
		System.err.println("WARNING: Unauthorized use of this software is prohibited");
		System.out.println();
		initialPrompt();		
	}

	/**
	 *  The initialPrompt method displays the initial login/registration prompt
	 */
	private static void initialPrompt() {
		while (true) {
			System.out.print("Type \"login\" to log in or \"register\" to register: ");
			String command = in.nextLine();
			if (command.toLowerCase().equals("login")) {
				login();
				break;
			} else if (command.toLowerCase().equals("register")) {
				register();
			} else {
				System.out.println("Unrecognized command");
			}
		}
	}

	/**
	 *  The register method gets registration information 
	 *  from the user to create a new user on the database
	 */
	private static void register() {
		while (true) {
			int i;
			System.out.print("Email Address: ");
			String email = in.nextLine();
			System.out.print("Username: ");
			String name = in.nextLine();
			System.out.print("Password: ");
			String pass = in.nextLine();
			System.out.print("Account type (0 for Client, 1 for Admin): ");
			String type = in.nextLine();
			try {
				i = Integer.parseInt(type);
			} catch(NumberFormatException nfe) {
				System.err.println("Please enter 0 or 1 for the Account type");
				continue;
			}
			try (Connection conn = ConnectionWithProperties.getConnection()) {
				CallableStatement stmt = conn.prepareCall("{CALL insert_user" +
						"(?,?,?,0,0,?)}");
				stmt.setString(1, name);
				stmt.setString(2, pass);
				stmt.setInt(3, i);
				stmt.setString(4, email);
				if (stmt.executeUpdate() > 0) {
					System.out.println("You have been registered successfully!");
					log.info("A user was registered with the following information: username: " + 
					name + " - email: " + email + " - account type: " + (i==0?"client":"admin"));
				} else {
					System.err.println("There was a problem registering your account.");
				}
			} catch(SQLException e) {
				System.err.println(e.getMessage());
				System.err.println("SQL state: " + e.getSQLState());
				System.err.println("Error code: " + e.getErrorCode());
			}
			break;
		}
		return;
	}

	/**
	 *  The login method acquires login information from the user and passes
	 *  it to the authorized method. If the authorized method returns true,
	 *  the user is logged in and the welcome screen is displayed
	 */
	private static void login() {
		boolean acquiredAuthentication = false;
		while (acquiredAuthentication == false) {
			System.out.print("Enter your username: ");
			String userName = in.nextLine();
			System.out.print("Enter your password: ");
			String password = in.nextLine();
			if (authenticate(userName,password)) {
				acquiredAuthentication = true;
			} else {
				System.out.println("Sorry, that didn't work. Try again.");
				initialPrompt();
			}
		}
		welcome(u);
	}

	/**
	 *  The authorized method validates the user's credentials in the database and creates a new
	 *  Admin or Client object representing the user. It returns true if the supplied username 
	 *  and password match a user on the database. Otherwise, it returns false. 
	 */
	private static boolean authenticate(String user, String pass) {
		try (Connection conn = ConnectionWithProperties.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bank_user WHERE username=? AND password=?");
			stmt.setString(1, user);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("is_verified") == 1) {
					if (rs.getInt("is_admin") == 1) {
						u = new Admin(user,true, rs.getString("email"));
					} else {
						u = new Client(user,false, rs.getString("email"));
					}
					return true;
				} else {
					System.err.println("Your account has not been verified yet.");
					log.warn("Unverified login attempt with username: " + user);
				}
			} else {
				System.err.println("Incorrect password/account does not exist");
			}
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return false;
	}

	/**
	 *  The welcome method greets the user upon logging in and displays available options (commands) 
	 */
	private static void welcome(User u) {
		log.info(u.getUserName() + " has logged into the system");
		displayOptions = DisplayOptions.options(u);
		System.out.println("\nWelcome, " + u.getUserName() + "\nHow can we serve you today?\n");
		while (true) {
			for (int i=0; i<displayOptions.size(); i++) {
				System.out.println((i+1)+") "+displayOptions.get(i));
			}
			String command = in.nextLine();
			try {
				int i = Integer.parseInt(command);
				u.performAction(u, i);
			} catch (Exception e) {
				System.out.println("Invalid command");
			}
		}
	}
	
	/**
	 *  The logoff method confirms that the user wants to log off.
	 *  Upon receiving confirmation, the program is terminated. 
	 */
	public static void logoff() {
		System.out.print("Are you sure you want to log off (Y/N)? ");
		if (in.nextLine().toLowerCase().equals("y")) {
			log.info(u.getUserName() + " has logged out of the system");
			in.close();
			System.exit(0);
		}
		return;
	}

}
