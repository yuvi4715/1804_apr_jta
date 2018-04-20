package com.revature.bankapp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.user;
import com.revature.service.BankAccountService;

public class UserInterface {
	final static Logger log = Logger.getLogger(UserInterface.class);
	
	private static final int MAIN = 0, LOGIN = 1, CREATEACCOUNT = 2, LOGGEDIN = 3, CREATEBANKACCOUNT = 4,
	UPDATEACCOUNT = 5, ACTIVATEACCOUNT = 6;
	private static int state = MAIN;
	private static boolean done = false;
	private static double balanceSigned = 1;
	private static user LoginUser = null;
	
	public static void stateMachine() {
		while (!done) {
			log.info(state);
			switch (state) {
			case MAIN:
				mainLoop();
				break;
			case LOGIN:
				logginLoop();
				break;
			case CREATEACCOUNT:
				CreateAccountLoop();
				break;
			case LOGGEDIN:
				loggedIn();
				break;
			case CREATEBANKACCOUNT:
				CreateBankAccount();
				break;
			case UPDATEACCOUNT:
				updateAccountLoop();
				break;
			case ACTIVATEACCOUNT:
				ActivateAccount();
				break;
			}
		}

	}

	private static void ActivateAccount() {
		List<user> li = BankAccountService.getAllUnactivatedUsers();
		for(user u: li) {
			System.out.println(u);
		
		boolean flag = BankAccountService.updateUser(u);
		
		if(flag) {
			System.out.println("Users " + u.getUsername() + " have been activated.");
		}
		else {
			System.out.println("Users " + u.getUsername() + " have not been activated at this time.");
		}
		}
		state = LOGGEDIN;		

	}

	private static void CreateAccountLoop() {

		Scanner in = new Scanner(System.in);
		int number = -1;
		int selectType = 0;
		while (true) {
			
			try {
				System.out.println("Enter (1) to create User or Enter (2) to create Admin.");
				selectType = Integer.parseInt(in.nextLine());
				
			} catch(NumberFormatException e) {
				
			}
			
			
			if(selectType == 1) {
				

			System.out.println("Please enter new account information.");

			System.out.println("Please enter new Username.");
			String NewUsername = in.nextLine();

			System.out.println("Please enter Password:");
			String NewPassword = in.nextLine();

			System.out.println("Please enter your Name:");
			String NewName = in.nextLine();

			System.out.println("Please enter your Lastname:");
			String NewLastName = in.nextLine();

			System.out.println("Please enter your Address:");
			String NewAddress = in.nextLine();

			System.out.println("Please enter your Email:");
			String NewEmail = in.nextLine();
			
			System.out.println("Please enter your initial Balance:");
			double NewBalance = in.nextDouble();

			

			state = MAIN;
			user newuser = new user(NewUsername, NewPassword, NewName, NewLastName, NewAddress, NewEmail, false, false, NewBalance);
			
			boolean flag = BankAccountService.createUser(newuser);
			
			if (flag) {
				System.out.println("Account successfully created.");
				System.out.println("Thank you. Your account is pending for approval.");
			}
			else  {
				System.out.println("Account not created.");
				continue;
			}
		
			
			break;
		
			}
			else if (selectType == 2) {
				
				System.out.println("Please enter new account information.");

				System.out.println("Please enter new Username:");
				String NewUsername = in.nextLine();

				System.out.println("Please enter Password:");
				String NewPassword = in.nextLine();

				System.out.println("Please enter your Name:");
				String NewName = in.nextLine();

				System.out.println("Please enter your Lastname:");
				String NewLastName = in.nextLine();

				System.out.println("Please enter your Address:");
				String NewAddress = in.nextLine();

				System.out.println("Please enter your Email:");
				String NewEmail = in.nextLine();
				
				System.out.println("Please enter your initial Balance:");
				double NewBalance = in.nextDouble();


				state = MAIN;
				user newuser = new user(NewUsername, NewPassword, NewName, NewLastName, NewAddress, NewEmail, true, false, NewBalance);
				
				boolean flag = BankAccountService.createAdmin(newuser);
				
				if (flag) {
					System.out.println("Account successfully created.");
					System.out.println("Thank you. Your account is pending for approval.");
				}
				else  {
					System.out.println("Account not created.");
					continue;
				}
			
				break;
				
				
			}
		}
	}

	private static void logginLoop() {

		String username, password;
		Scanner scanner = new Scanner(System.in);
		int number = -1;
		while (true) {
			System.out.println("Please press Enter to continue or \"0\" (zero) to exit.");
			String option = scanner.nextLine();
			try {
				number = Integer.parseInt(option);
			} catch (NumberFormatException e) {
			}
			if (number == 0) {
				state = MAIN;
				return;
			}
			System.out.println("Please Enter Username:");
			 username = scanner.nextLine();
			System.out.println("Please Enter Password:");
			 password = scanner.nextLine();
			
			LoginUser = BankAccountService.userVerification(username, password);
			
			if(LoginUser == null) {
				state = MAIN;
				System.out.println("Login failed.");
				return;
				
			}
			System.out.println("Login Successful.");

			state = LOGGEDIN;
			return;
		}
	}
	
	
	

	private static void CreateBankAccount() {

		
		System.out.println("Please choose your bank account type:");
		System.out.println("1) Checking");
		System.out.println("2) Savings");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int option = -1;
		try {                                  //Validar que números sean entre 1 y 2.
			option = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}
		if(option<0) {
			System.out.println("Invalid input.");
			return;
		}
		System.out.println("Account created successfully.");
		System.out.println("Please enter initial balance $.");
		try {
			double NewBalance = scanner.nextDouble();

		} catch 
			(InputMismatchException e) {
		}
	
		
	}

	private static void loggedIn() {
		log.info(LoginUser.getUsername() + " has logged in.");


		System.out.println("What would you like to do?");
		System.out.println("1) Create bank account");
		System.out.println("2) Deposit & Withdraw funds");
		System.out.println("3) Activate pending Accounts");
		
		Scanner scanner = new Scanner (System.in);
		String s = scanner.nextLine();
		int option = -1;
		try {
			option = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}
		if(option<0) {
			System.out.println("Invalid input");
			return;
		}
		if(option==1) {
			state = CREATEBANKACCOUNT;
			return;
		}
		if(option==2) {
			balanceSigned = 1;
			state = UPDATEACCOUNT;
			return;
		}
		
		if(option==3) {
		state = ACTIVATEACCOUNT;
		return;
		}
		
	}



	private static void mainLoop() {
		Scanner scanner = new Scanner(System.in);
		int r;
		int number = 0;
		while (true) {
			System.out.println("Welcome to The Superhero Bank:");
			System.out.println("1) Login");
			System.out.println("2) Create Account");
			System.out.println("3) Exit");
			 r = scanner.nextInt();
			try {
				number = (r);
				if (number < 4 && number > 0)
					break;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		if (number == 1) {
			state = LOGIN;
			return;
		} else if (number == 2) {
			state = CREATEACCOUNT;
			return;
		} else if (number == 3) {
			System.out.println("Good Bye!");
			done = true;
			return;
		}
	}
	
	
	private static void updateAccountLoop() {
		
		BankAccountService.updateAccount(LoginUser);
		log.info(LoginUser.getUsername() + " has completed a transaction.");
		state = LOGGEDIN;
		return;
		
		
		
//		System.out.println("Checking or Savings Account?");
//		System.out.println("1) Checking");
//		System.out.println("2) Savings");
//		Scanner scanner = new Scanner(System.in);
//		String s = scanner.nextLine();
//		int option = -1;
//		try {                                  //Validar que números sean entre 1 y 2.
//			option = Integer.parseInt(s);
//		} catch (NumberFormatException e) {
//		}
//		if(option<0) {
//			System.out.println("Invalid input.");
//			return;
//		}
//
//		System.out.println("Please enter the"+ (balanceSigned < 0?"Withdraw":"Deposit")+ "amount.");
//		s = scanner.nextLine();
//		double amount = -1;
//		try {                                  
//			amount = Double.parseDouble(s);
//		} catch (NumberFormatException e) {
//		}
//		if(amount<0) {
//			System.out.println("Invalid input.");
//			return;
//		}
		
	}
}	
	


