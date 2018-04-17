//package com.revature.bankingApp;
//
//import java.math.BigDecimal;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//import com.revature.bankModel.Customer;
//import com.revature.bankService.BankService;
//
//public class executeBank {
//
//	public static void startBank() {
//	
//		Scanner userInput = new Scanner(System.in);
//		boolean userDecision = true; // It's simpler from true to false in switch although
//										// it linguistically makes more sense going from false to true.
//		System.out.println("=============================\n Welcome to the Goldenrod City Bank!\n"+"============================= ");
//
//		System.out.println("Please enter number applicable to your needs:\n"+
//				"1: User Login\n"+"2: Admin Login\n"+"3: Create New User\n"+"4: Create New Admin\n");
//
//		String userIn = userInput.nextLine();
//		
//		while(userDecision){
//			
//			switch(userIn){
//			case"1":{
//				userDecision=false;
//				System.out.println("Proceeding to User Login ");
//				Customer customer = userLogin(userInput);
//				if (customer == null) {
//					System.out.println("Invalid username/password combination.");
//					userInput.close();
//					startBank();
//				}else {
//					System.out.println("Success");
//					customerActions(customer, userInput);
//					break;
//				}
//				}
//	
//			case"2":{
//				System.out.println("Proceeding to Admin Login ");
//				adminLogin(userInput);
//				userDecision=false;
//				break;
//				}
//		
//			case"3":{
//				System.out.println("Proceeding to Create New User");
//				userDecision=false;
//				//Customer customer = createNewUser(userInput);
//				break;
//				}
//			case"4":{
//				System.out.println("Proceeding to Create New Admin");
//				createNewAdmin(userInput);userDecision=false;
//				break;
//				}
//			default:{
//				System.out.println("Wrong input. Please try again.");
//				userIn=userInput.nextLine();
//			}}
//		}
//
//	}
//
//	static Customer userLogin(Scanner userInput) {
//		System.out.println("Enter username: ");
//		String tempName = userInput.nextLine();
//		System.out.println("Enter password: ");
//		String tempPass = userInput.nextLine();
//		Customer customer = BankService.loginCustomer(tempName, tempPass);
//		return customer;
//	}
//
//	static Customer createNewUser(Scanner userInput) {
//		System.out.println("Enter desired username: ");
//		String tempName = userInput.nextLine();
//		System.out.println("Enter desired password: ");
//		String tempPassword = userInput.nextLine();
//		System.out.println("Enter first name: ");
//		String tempFirstname = userInput.nextLine();
//		System.out.println("Enter last name: ");
//		String tempLastname = userInput.nextLine();
//		Customer customer = new Customer(tempName, tempPassword, tempFirstname, tempLastname);
//		System.out.println("Welcome to the Goldenrod Bank! We hope we enjoy your stay.");
//		return customer;
//	}
//
//	static void customerActions(Customer customer, Scanner userInput) {
//		boolean userDecision = true;
//		System.out.println(customer.getFirstName() + " " + customer.getLastName() + " welcome back to the Goldenrod Bank. What"
//				+ "can we do for you today? ");
//		System.out.println("Enter number corresponding to desired account action:\n "
//				+ "1: Check Account Balance\n 2: Deposit Money\n 3: Withdraw Money\n 4: Check Transaction History\n"
//				+ "5: Logout");
//		String userIn = userInput.nextLine();
//		
//		while(userDecision){
//			
//			switch(userIn){
//			case"1":{
//				System.out.println("Checking Account Balance: ");
//				System.out.println("You have $" + BankService.checkAccountBalance(customer.getUserName()) +
//						" in your account.");
//				}
//			case"2":{
//				depositMoney(customer, userInput);
//				}
//		
//			case"3":{
//				withdrawMoney(customer, userInput);
//				}
//			case"4":{
//				System.out.println("This is your transaction history: ");
//				BankService.viewTransactions(customer.getUserName());
//				}
//			case"5":{
//				System.out.println(customer.getFirstName() + ", thank you for using the Goldenrod Bank.");
//				userInput.close();
//				userDecision = false;
//				break;
//				}
//			default:{
//				System.out.println("Wrong input. Please try again.");
//				userIn=userInput.nextLine();
//				}
//			}
//		}
//		
//	}
//	
//		
//	static void adminLogin(Scanner userInput) {
//	}
//
//	static void createNewAdmin(Scanner userInput) {
//		System.out.println(BankService.getAllCustomers());
//		
//	}
//	
//	static void depositMoney(Customer customer, Scanner userInput) {
//		BigDecimal deposit = new BigDecimal(0);
//		boolean realNumber = false;
//		while(realNumber == false) {
//			System.out.println("How much would you like to deposit?");
//			try {
//				deposit = userInput.nextBigDecimal();
//				realNumber = true;
//			}catch(InputMismatchException e) {
//				System.out.println("Not a valid number, please try again.");
//				userInput.nextLine();
//			}	
//		}
//		if(deposit.longValue() < 0) {
//			System.out.println("You cannot deposit negative numbers.");
//		}else {
//			realNumber = BankService.addTransaction(1, deposit);
//			if (realNumber == false) {
//				System.out.println("Something has gone wrong, please try again.");
//			}else {
//			System.out.println("You have added $" + deposit + " to your bank account.");
//			}
//		}
//	}
//	
//	static void withdrawMoney(Customer customer, Scanner userInput) {
//		BigDecimal withdrawl = new BigDecimal(0);
//		boolean realNumber = false;
//		while(realNumber == false) {
//			System.out.println("How much would you like to withdraw?");
//			try {
//				withdrawl = userInput.nextBigDecimal();
//				realNumber = true;
//			}catch(InputMismatchException e) {
//				System.out.println("Not a valid number, please try again.");
//				userInput.nextLine();
//			}	
//		}
//		if(withdrawl.longValue() < 0) {
//			System.out.println("You cannot deposit negative numbers.");
//		}else if(withdrawl.longValue() > BankService.checkAccountBalance(customer.getUserName())) {
//			System.out.println("You lack sufficient funds to withdraw $" + withdrawl + " from your bank account.");
//		}else {
//			realNumber = BankService.addTransaction(1, withdrawl);
//			if (realNumber == false) {
//				System.out.println("Something has gone wrong, please try again.");
//			}else {
//			System.out.println("You have withdrawed $" + withdrawl + " from your bank account.");
//			}
//		}	
//	}
//
//}
