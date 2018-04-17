package com.kobio.controller;

import java.util.List;

import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;


import com.kobio.model.Account;
import com.kobio.model.Person;
import com.kobio.model.Transaction;
import com.kobio.service.AccountService;
import com.kobio.service.PersonService;
import com.kobio.service.TransactionService;


public class Controller {

	public static Person p;
	public static Account a;
	static Scanner in = new Scanner(System.in);
	
	
	final static Logger logger =Logger.getLogger(Controller.class);
	public void menu() {
		System.out.println("Welcome to Bank of Revature!" + "\n");
		System.out.println("Please select a number:" + "\n" + "1. Sign up for an account." + "\n"
				+ "2. Login to your account." + "\n");
		int answer = in.nextInt();
	logger.info("User entered the application selecting switch case" + answer);
		switch (answer) {
		case 1:
			signup();
	logger.info("signup");
			break;

		case 2:
			login();
	logger.info("login");
			break;
		}

	}

	public void signup() {
		System.out.println("Would you like to Create an Admin or User Account?" + "\n");
		boolean answer = false;
		while (answer == false) {
			String response = in.next();
			if (response.equalsIgnoreCase("admin")) {
				answer = true;
				fillinform(response);
				menu();
			}

			else if (response.equalsIgnoreCase("user")) {

				answer = true;
				fillinform(response);

				// menu();

			} else {
				System.out.println("Enter either " + "Admin" + " or" + " user");
				logger.error("Wrong selection. Pick either Admin or user");
				signup();
			}
		}
	}

	public void login() {
		System.out.println("Login: " + "\n");
		System.out.print("Username:");
		String username = in.next();
		System.out.println("Password:");
		String password = in.next();
		a = new Account();
		p = PersonService.getCustomer(username);

		if (username.equals(p.getUsername())) {
			if (password.equals(p.getPassword())) {
				logger.info("successfully logged in");
				//System.out.println(a.getapprove());
				if(a.getapprove() == 'X')
				{
					System.out.println("Your application has been denied, Your credit score rating is below the approval rating - 300 ");
					System.exit(0);
					
				}
				if (a.getapprove() == 'Y') {
					a.setPerson(p);
					System.out.println("Welcome to your portal " + p.getFirstname() + p.getLastname() + p.getRole());
					logger.info("Welcoming user" + p.getLastname() + "to portal");
					portal();
				} else {
					System.out.println("Your account is pending approval. Please check again later");
					logger.error("This user is still pending approval");
				}

			} else {
				System.out.println("The password you entered does not match the username. Try again");
				logger.error("Password does not match username");
				login();
			}
		} else {
			System.out.println("This username is not in our database. Sign up!");
			logger.error("username not in the database");
			menu();
		}

	}

	public void fillinform(String resp) {

		// TODO Auto-generated method stub
		a = new Account();
		if (resp.equalsIgnoreCase("admin")) {
			System.out.println("Please enter admin code" + "\n");
			String code = in.next();
			if (code.equalsIgnoreCase("revature")) {
				a.setApprove('Y');
				logger.info("admin user succesfully registered");
			} else {
				System.out.println("The code entered was wrong. Please sign up for a user account");
				logger.error("Unsuccessful admin registeration");
				signup();
			}
		}

		generatecreditscore();
		System.out.println("Please fill out the following form:" + "\n");
		System.out.println("Firstname:");
		String firstname = in.next();
		System.out.println("Lastname:");
		String lastname = in.next();
		System.out.println("Username: (*must be unique and be between 3 - 5 characters)");
		String username = in.next();
		// check db and constraints
		System.out.println("Password: (*must be between 5 and 10 characters)");
		String password = in.next();
		// check constraints
		System.out.println("SSN:");
		String ssn = in.next();
		// check constraints
		System.out.println("Email:");
		String email = in.next();
		// check db and format
		String role = resp.toLowerCase();

		// allow a thread update the DB in your DAO after you set the user
		// person and everything.
		p = new Person(firstname, lastname, username, password, role, ssn, email); // generate
																					// ID
																					// and
																					// if
																					// everything
																					// on
																					// top
																					// checks
																					// intitalize
																					// person
		// p.setID();
		logger.info("creating new person");
		PersonService.CreatePerson(p);
		if(p.getRole().equalsIgnoreCase("admin"))
		{
			
		}
		else{
		System.out.println("Thank you for creating an account. Please be patient while we review your application");
		}
	}

	public void portal() {
		if (p.getRole().equalsIgnoreCase("admin")) {
			System.out.println("1. Approve new user account" + "\n" + "2. Approve loan requests from users" + "\n"
					+ "3. Log Out.");
			int answer = in.nextInt();
			switch (answer) {
			case 1:
				userapproval();
				break;
			case 2:
				loanapproval();
				break;
			case 3:
				System.out.println("Thank you for using our service");
				System.exit(0);
			default:
				System.out.println("Please choose a valid number");
				portal();
			}
		} else {
			System.out.println("1. Deposit" + "\n" + "2. Withraw" + "\n" + "3. Balance Inquiry" + "\n"
					+ "4. Apply for a loan" + "\n" + "5. Delete your account" + "\n" + "6. Log Out.");
			int answer = in.nextInt();
			switch (answer) {
			case 1:
				System.out.println("How much would you like to deposit?");
				int amount = in.nextInt();
				logger.info("user" + p.getUsername() + "depositing" + amount);
				deposit(amount);
				break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				int am = in.nextInt();
				logger.info("user" + p.getUsername() + "withdrawing" + am);
				withdraw(am);
				break;
			case 3:
				System.out.println("Your Balance: " + a.getBalance());
				Transaction t= TransactionService.getTransaction(a);
				try{
					if(t.getLoangranted() == 'y')
					{
						System.out.println("Your loan request of" + " "+ t.getLoanrequested() +  " was approved and is shown in your balance");
						System.out.println("The due date for your full loan payback:" + " " + t.getLoanduedate() );
					}
					else if(t.getLoangranted()=='n')
					{
						System.out.println("Sorry your loan was not approved. Minimum credit for a loan approval is 500");
					}
				}
				catch(NullPointerException e)
				{
					
				}
				
				portal();
				break;
			case 4:
				System.out.println("Apply for a loan "); //// doooooo
				loanapplication();
				break;
			case 5:
				System.out.println("Are you sure you want to delete your account?"); /// dooooooo
				break;
			case 6:
				System.out.println("Thank you for using our service");
				System.exit(0);

			default:
				System.out.println("Please choose a valid number");
				portal();

			}
		}
	}

	private void loanapplication() {
		// TODO Auto-generated method stub
		System.out.println("Please fill out the following application");
		System.out.println("Lastname:");
		String lastname = in.next();
		System.out.println("SSN:");
		String ssn = in.next();
		System.out.println("Loan Amount:");
		int n = in.nextInt();
		if (p.getSsn().equalsIgnoreCase(ssn)) {
			TransactionService.createloanTransaction(n, a);
			System.out.println(
					"Loan application successful. Please check back again to see if it has been approved or declined");
			portal();
		} else {
			System.out.println("The ssn does not match this account. Please try again");
			loanapplication();
		}
	}

	public void generatecreditscore() {
		Random n = new Random();
		int y = n.nextInt(800 + 1 - 200) + 200;
		a.setCreditscore(y);
	//	System.out.println(y);
	}

	public void deposit(int amount) {
		if (amount <= 0) {
			System.out.println("Please enter a number greater than 0"); // put
																		// this
																		// when
																		// they
																		// are
																		// passing
																		// amount
			int newamount = in.nextInt();
			deposit(newamount);
		} else {
			// update balance in database
			// account.setBalance(account.getBalance()+amount);
			a.setBalance(a.getBalance() + amount);
			Boolean t = AccountService.updateAccount(a, ' ');
			System.out.println("Succesful: New balance is, "  + a.getBalance());
			
			portal();
		}
	}

	public void withdraw(int amount) {
		if (amount <= 0) {
			System.out.println("Please enter a number greater than 0"); // put
																		// this
																		// when
																		// they
																		// are
																		// passing
																		// amount
		}
		if (amount >= a.getBalance()) {
			System.out.println("Your balance is: " + a.getBalance() + " Please withdraw an amount less that balance.");
		}
		if (a.getBalance() <= 0) {
			System.out.println("You cannot withdraw from your account. Please deposit money."); // take
																								// back
																								// to
																								// menu
		} else {
			// update balance in database
			a.setBalance(a.getBalance() - amount);
			Boolean t = AccountService.updateAccount(a, ' ');
			System.out.println("Succesful: New balance is, " + a.getBalance());
			logger.info("Withdrawal succesful, balance updated");
			portal();
		}
	}

	public void loanapproval() {
		logger.info("Approving user loans");
		boolean answer1 = false;
		do {
			List<Account> account = AccountService.getAllAccount();
			List<Person> person = PersonService.getAllPerson();
			List<Transaction> transaction = TransactionService.getallTransactions();
			int u = 0; // index
			for (Transaction t : transaction) {
				for (Account y : account) {
					for (Person q : person) {
						if (t.getAccount().getID() == y.getID() && q.getID() == y.getPerson().getID()) {
							System.out.println(u + "  " + q.getFirstname() + "  " + q.getLastname() + "  "+ "Credit Score: "+" "
									+ y.getCreditscore() + "Loan Request amount:" + "  " + t.getLoanrequested() + "  " + "on" + " "+ t.getDatetime());
							u++;
						}
					}
				}
			}
			boolean answer = false;

			do {
				System.out.println(
						"Select a number for the user you would like to approve their loan. Minimum credit score for loan approval is 600. ");
				int index = in.nextInt();
				if (index >= 0 && index <= transaction.size() - 1) {
					System.out.println("Do you want to 1. Approve or 2. Decline " + "\n" + "Please select a number");
					int n = in.nextInt();
					if(n==1 || n==2) {
						System.out.println("Are you sure? (Yes or No)");
						String approve = in.next();
						if (approve.equalsIgnoreCase("yes")) {
							answer = true;
							logger.info("Approved user with credit score of" + account.get(index).getCreditscore());
							if(n==1){approve = "yes";}else{approve = "no";}
							TransactionService.approveloanTransaction( transaction.get(index), approve);
							System.out.println("Do you want to continue approving?");
							String ans = in.next();
							if (ans.equalsIgnoreCase("no")) {
								answer1 = true;
							}
						} else {
							TransactionService.approveloanTransaction( transaction.get(index), approve);
						}
					}
					else{}
					
				}
			} while (answer = false);
		} while (answer1 = false);
		portal();
	}

	public void userapproval() {
		boolean answer1 = false;
		logger.info("Approving new users");
		do {
			List<Account> account = AccountService.getAllAccount();
			List<Person> person = PersonService.getAllPerson();
			int u = 0;
			for (Account y : account) {
				for (Person i : person) {
					if (i.getID() == y.getPerson().getID()) {

						System.out.println(
								u + " " + i.getFirstname() + " " + i.getLastname() + "\n " + y.toString() + "\n");
						u++;
						break;
					}
				}

			}
			boolean answer = false;

			do {
				System.out.println(
						"Select a number for the user you would like to approve. (please select only users with 'N' (Not Approved) ");
				int index = in.nextInt();
				if (index >= 0 && index <= account.size() - 1) {
					if (account.get(index).getapprove() == 'Y') {
						System.out.println("Please select a user that hasn't been approved.");
						logger.error("User has already been approved");
					} else {
						System.out.println("Approve: 'Yes', Decline: 'NO' ");
						String y = in.next();
						if (y.equalsIgnoreCase("yes")) {
							answer = true;
							account.get(index);
							logger.info("Approved user with credit score of" + account.get(index).getCreditscore() );
							AccountService.updateAccount(account.get(index), 'Y');
							System.out.println("Do you want to continue approving?");
							String y2 = in.next();
							if (y2.equalsIgnoreCase("no")) {
								answer1 = true;
							}
						} else if(y.equalsIgnoreCase("NO")) {
							answer = true;
							account.get(index);
							logger.info("Decline user with credit score of" + account.get(index).getCreditscore() );
							AccountService.updateAccount(account.get(index), 'X');
							System.out.println("Do you want to continue approving?");
							String y2 = in.next();
							if (y2.equalsIgnoreCase("no")) {
								answer1 = true;
							}
						}
						else
						{
							break;
						}
					}
				}
			} while (answer = false);
		} while (answer1 = false);
		portal();
	}

}
