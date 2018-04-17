package com.revature.main;

import java.sql.Connection;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.account_imp.Account_Impl;
import com.revature.model.User;
import com.revature.util.MyConnection;

public class App {
	static Account_Impl a = new Account_Impl();
	final static Logger log = Logger.getLogger(App.class);
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		String un = null, pw = null;
		System.out.println("Hello!  Welcome to [bank]'s banking app!  Please enter your username now"
							+ " or enter Create to create a new account");
		while(true) {
			System.out.print("Awaiting input: ");
			un = sc.nextLine();
			switch(un) {
				case "Create":
					System.out.println("Enter your desired username:");
					un=sc.nextLine();
					System.out.println("Checking availability...");
					User u = a.getUserInfo(un);
					if(un.equals("Create")) {
						System.out.println("Nice try.");
					}
					else if(u==null) {
						System.out.println("That username is available!  Creating account now.");
						a.openAccount(0, "default", "default", un, "password", 0, 0);
						System.out.println("Account created with default password 'password' "
								+ " and $0 balance - taking you back to login screen");
						break;
					}
					else {
						System.out.println("We're sorry, that username has already been taken.");
						break;
					}
				case "Admin":
					System.out.println("Creating admin account - enter deseired username");
					un=sc.nextLine();
					System.out.println("Checking availability...");
					User au = a.getUserInfo(un);
					if(un.equals("Create")) {
						System.out.println("Nice try.");
					}
					else if(au==null) {
						System.out.println("That username is available!  Creating account now.");
						a.openAccount(0, "default", "default", un, "password", 1, 1);
						System.out.println("Account created with default password 'password' "
								+ " and $0 balance - taking you back to login screen");
						break;
					}
					else {
						System.out.println("We're sorry, that username has already been taken.");
						break;
					}
				default:
					System.out.println("Checking username...");
					User ul = a.getUserInfo(un);
					if(ul == null) {
						System.out.println("We have no records of that username.  Please try again.");
					}
					else {
						System.out.println("Welcome, " + un + "!  Please enter your password below");
						while(true) {
							System.out.print("Password: ");
							pw = sc.nextLine();
							if (pw.equals(ul.getPw())){
								System.out.println("Login successful.");
								if(ul.getAdmin()) {
									adminRun(ul);
								}
								else{
									userRun(ul);
								}
							}
							else {
								System.out.println("That password does not match our records.  Please try again.");
							}
						}
					}
			}
		}
	}
	
	public static void userRun(User u) {
		log.info("User" + u.getU_name() + " logged on." );

		String command = null;
		int id = u.getId();
		Scanner sc = new Scanner(System.in);
		if(u.isVerified()) {
			while(true) {
				System.out.println("Enter your command now, or type 'Help' for a list of commands.");
				command = sc.nextLine();
				switch(command) {
					case "Help":
						userHelp();
						break;
					case "Change fName":
						System.out.println("Enter your first name now.");
						a.firstNameChange(id, sc.nextLine());
						break;
					case "Change lName":
						System.out.println("Enter your last name now.");
						a.lastNameChange(id, sc.nextLine());
						break;
					case "Change Username":
						System.out.println("Enter your desired username to check availability.");
						String new_u = sc.nextLine();
						u = a.getUserInfo(new_u);
						if(u == null) {
							System.out.println("Changing password");
							a.usernameChange(id, new_u);
						} else {
							System.out.println("Error - that username is already taken.");
						}
					case "Change Password":
						System.out.println("Enter your new password.");
						a.passwordChange(id, sc.nextLine());
						break;
					case "Deposit":
						System.out.println("Please enter how much money you would like to deposit.");
						double d = sc.nextDouble();
						a.deposit(id, d);
						u.setBalance(u.getBalance()+d);
						break;
					case "Withdraw":
						System.out.println("Please enter how much money you would like to withdraw.");
						double da = sc.nextDouble();
						a.withdrawal(id, da);
						u.setBalance(u.getBalance()-da);
						break;
					case "Transfer":
						System.out.println("Enter the id number of the account you would like to transfer money into.");
						int i = sc.nextInt();
						System.out.println("Enter the transfer amount");
						double db = sc.nextDouble();
						a.transfer(id, i, db);
						u.setBalance(u.getBalance()-db);
						break;
					case "Check":
						System.out.println("Your account contains $" + u.getBalance());
						break;
					case "logout":
						log.info("User" + u.getU_name() + " logged out." );
						System.exit(0);
					default:
						System.out.println("We're sorry, we don't recognize that input.  Please try again.");
				}
			}
		}
		else {
			System.out.println("We're sorry, your account is still waiting on verification.");
		}
	}
	
	public static void adminRun(User u) {
		log.info("User" + u.getU_name() + " logged on." );

		String command = null;
		int id = u.getId();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter your command now, or type 'Help' for a list of commands.");
			command = sc.nextLine();
			switch(command) {
				case "Help":
					userHelp();
					break;
				case "Change fName":
					System.out.println("Enter your first name now.");
					a.firstNameChange(id, sc.nextLine());
					break;
				case "Change lName":
					System.out.println("Enter your last name now.");
					a.lastNameChange(id, sc.nextLine());
					break;
				case "Change Username":
					System.out.println("Enter your new username to check availability.");
					u = a.getUserInfo(sc.nextLine());
				case "Change Password":
					System.out.println("Enter your new password.");
					a.passwordChange(id, sc.nextLine());
					break;
				case "Deposit":
					System.out.println("Please enter how much money you would like to deposit.");
					a.deposit(id, sc.nextDouble());
					break;
				case "Withdraw":
					System.out.println("Please enter how much money you would like to withdraw.");
					a.withdrawal(id, sc.nextDouble());
					break;
				case "Transfer":
					System.out.println("Enter the id number of the account you would like to transfer money into.");
					int i = sc.nextInt();
					System.out.println("Enter the transfer amount");
					a.transfer(id, i, sc.nextDouble());
					break;
				case "Check":
					System.out.println("Your account contains $" + u.getBalance());
					break;
				case "logout":
					log.info("User" + u.getU_name() + " logged out." );
					System.exit(0);
				case "Verify":
					System.out.println("Enter the id number of the account you would like to verify.");
					a.verify(sc.nextInt());
					break;
				default:
					System.out.println("We're sorry, we don't recognize that input.  Please try again.");
			}
		}
	}
	
	public static void userHelp() {
		System.out.println("Commands (case-sensitive):\nChange fName to change your first name. \nChange lName to change your last name."
				+ "\nChange Username to change your username.\n Change Password to change your password.\n Deposit to deposit money."
				+ "\nWithdraw to withdraw money.\nTransfer to transfer money.");
	}
	
	public static void adminHelp() {
		System.out.println("Commands (case-sensitive):\nChange fName to change your first name. \nChange lName to change your last name."
				+ "\nChange Username to change your username.\n Change Password to change your password.\n Deposit to deposit money."
				+ "\nWithdraw to withdraw money.\nTransfer to transfer money.\nVerify to verify a user account");
	}
}
