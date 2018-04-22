package com.revature.application;

import java.util.Scanner;

import com.revature.service.BankService;

import myBankModel.Bank;

// Class serves as the application that allows a user to use the Bank Service.  Program will continue to run until user logs out and exits application.
public class BankAppMain {
	
	Scanner k = new Scanner(System.in);
	BankService service = new BankService();
	Bank bank = new Bank();
	// Constructor
		public BankAppMain() {
			//log.info("User has started application");
			System.out.println("Welcome to Lucy Int'l Bank ");
			System.out.println("        .....meeting your banking needs ");
			
			mainMenu();
			k.close();
		}
		//The main menu of the Bank
		public void mainMenu() { // Page requesting log in
		//	log.info("Main menu launched.");
			int option = 0;
			boolean mainOperation = true;
			String entry1;
			String entry2;
			
				System.out.println("Main Menu");
				System.out.println();
				System.out.println("What do you wish to do?");
				System.out.println("1: Log in ");
				System.out.println("2: Create an account.");
				System.out.println("3: Exit Application.");
				option = k.nextInt();
				switch (option) {
				case 1 :
//			//		log.info("Log in as user selected");
					System.out.println("Enter your username.");
					entry1 = k.next();
					System.out.println("Enter your password");
					entry2 = k.next();
					bank = service.getBankUser(entry1); 
					System.out.println(bank.toString());
					if ( bank.getPassword().equalsIgnoreCase(entry2)) {
						if(bank.getPrivilege().equalsIgnoreCase("Admin")) {
							System.out.println("Admin Login Succefull");
							adminMenu();
					}
						else
							{
							if(bank.getIsApproved().equalsIgnoreCase("True")) {
							System.out.println(" user Login Succsfull");
							userMenu();
							} else {
								System.out.println("Pending Approval");
								mainMenu();
							}
							
							}
					}
																
					else
					{
						System.out.println("Invalid Password try password again");
					}
				break;
					//get bankUser			
 				
				case 2 :
			//		log.info("Operation to create a new user is selected");
					System.out.println("You have selected to create a new account!");
					System.out.println("Please remember that in order to use your new account you must wait for approval!");
					String userType = "user"; // set to null before use
					String userApproved = "false";
					String fName;
					String lName;
					String uName;
					String pWord;
				
					System.out.println("Please enter the first name.");
					fName = k.next();
					System.out.println("Please enter the last name.");
					lName = k.next();
					//do { 
						System.out.println("Please enter the username of the account.");
						uName = k.next();
						
					//} while(true);
					
					System.out.println("username is: " + uName);
					System.out.println("Please enter the password for the account");
					pWord = k.next();
					
					Bank tempUser = new Bank(fName, lName, uName, pWord, userType, userApproved, 0, 0);
					service.insertBank_Account(tempUser); ///////
					System.out.println("A new " + userType + " with the username " + 
					uName + " has been added");
					System.out.println("Account will be validated in 24hours, check back later");
				
					
					break;
				
				case 3:
//					log.info("Application is being exited");
					System.out.println("Exiting application, thank you for your business!");
					System.exit(0);
					mainOperation = false;
					break;
					
				
				default :
					System.out.println("Invalid input, please try again.");
					break;
					
				} while (mainOperation == true);
				
		}
				
		////////////////////////////////////
				
				
				// user menu, set for normal users. If user is an admin, they are required to use admin menu.
				public void userMenu() { // Menu for normal users
//					log.info("User menu entered");
				
					System.out.println(bank.getIsApproved());
					String approved = "false";
					if (bank.getIsApproved().equals(null)) {
						approved = "true";
					} else if (bank.getIsApproved().equals("true")) {
						approved = "true";
					}
					if (approved.equals("true")) {
				//		log.info("User menu accessed");
						int choice = 0;
						System.out.println("Welcome to the user menu " + bank.getFirstName() + " !");
						System.out.println("What would you like to do?");
						System.out.println();
						int amount;
						boolean operation = false;
//						do {
//							if (bank.getPrivilege().equals("admin")) {
//								System.out.println("Sorry, but you are an admin - please log in as one!");
//								operation = true;
//				//				log.warn("User turned out to be an admin, heading back to main menu.");
//								break;
//							}
							System.out.println("Enter 1: To deposit  into checking account");
							System.out.println("Enter 2: To withdraw cash from checking account");
							System.out.println("Enter 3: To deposit cash into savings account");
							System.out.println("Enter 4: To withdraw cash from savings account");
							System.out.println("Enter 5: To log out");
							choice = k.nextInt();
							switch (choice) {
							case 1 :
				//				log.info("User attempts to deposit cash into checking");
								System.out.println("Enter amount to deposit into checking.");
								amount = k.nextInt();
								if (BankService.depositChecking(bank, amount)) {
									bank = BankService.getBankUser(bank.getUserName());
									System.out.println("Deposit successful. New balance is:" + bank.getCheckingBalance());
									userMenu();
									break;
								} else {
									System.out.println("An error occurred, please try again");
									break;
								}
							case 2 :
					//			log.info("User attempts to withdraw from checking");
								System.out.println("Enter amount to withdraw from checking.");
								amount = k.nextInt();
								if (bank.getCheckingBalance() - amount >= 0) {
									BankService.withdrawChecking(bank, amount);
									bank = BankService.getBankUser(bank.getUserName());
									System.out.println("Withdraw successful. New balance is: " + bank.getCheckingBalance());
								
									userMenu();
									break;
								} else {
									System.out.println("An error occurred or insufficient funds. Please try again");
									break;
								}
								
							case 3:
					//			log.info("User attempts to deposit cash into savings");
								System.out.println("Enter amount to deposit into savings.");
								amount = k.nextInt();
								if (BankService.depositSavings(bank, amount)) {
									bank = BankService.getBankUser(bank.getUserName());
									System.out.println("Deposit successful. New balance is: " + bank.getSavingBalance());
									userMenu();
									break;
								} else {
									System.out.println("An error occurred, please try again");
									break;
								}
							
							case 4 :
						//		log.info("User attempts to withdraw from savings");
								System.out.println("Enter amount to withdraw from savings.");
								amount = k.nextInt();
								if (bank.getSavingBalance() - amount >= 0) {
									BankService.withdrawSavings(bank, amount);
									bank = BankService.getBankUser(bank.getUserName());
									System.out.println("Withdraw  New balance is: " + bank.getSavingBalance());
									userMenu();
									break;
								} else {
									System.out.println("An error occurred or insufficient funds. Please try again");
									break;
								}
							case 5:
				//				log.info("User Logs out.");
								System.out.println("ThankYou for banking with us!");
								System.exit(0);
								bank = null;
								operation = true;
								break;
							
							default :
								System.out.println("Incorrect input, please try again");
							} // end of switch
					}
				}
				
				// Menu strictly allowed to admins, if user tries to access it, they will be denied.
				public void adminMenu() { // Menu ONLY for admins
					//log.info("User " + currentUser.getUserName() + " has attempted to log in as an admin");
					int choice = 0;
				// Menu strictly allowed to admins, if user tries to access it, they will be denied.
				
			////	if (bank.getPrivilege().equals("admin")) {
					//log.info("Admin log in is successful.");
					System.out.println("Welcome Admin " + bank.getFirstName() + " !");
					System.out.println("What wold you like to do?");
					System.out.println();
					int amount;
					String userSelection = null;
					boolean operation = false;
					//do {
				
				
						System.out.println("Enter 1: To Approve a new user.");
						System.out.println("Enter 2: To log out");
						choice = k.nextInt();
						switch (choice) {
						
						
//					
				case 1 :
					System.out.println("You have selected to approve a new user, please enter the username of the user to be approved.");
					userSelection = k.next();
					
					 service.validateUser(userSelection);
		//				log.info("Admin attemps to approve user");
						System.out.println("User " + userSelection + " has been approved");
						break;
					
			//			log.error("Approval fails");
						//System.out.println("Error, user does not exist or something went wrong. Try again.");
							//	break;
						
						
				
				
					case 2 :
						System.out.println("Logging you out.");
					//			log.info("Admin logs out.");
						bank = null;
						operation = true;
						break;
						
					default :
						System.out.println("Incorrect choice, try again.");
						}
						
				}
	
// switch end
//					} else {
//					//	log.info("User log in procedure fails to validate user or user is an admin.");
//						System.out.println("We are sorry, but your account has not been approved yet.");
//						System.out.println("Please wait for your account to be approved by an administrator.");
//						System.out.println("Otherwise you are an admin and should be using this log on procedure.");
//						System.out.println("Logging you out...");
//						bank = null;
//				
//		}		
		
		public static void main(String[] args) {
			BankAppMain t = new BankAppMain();
		}
				


}		


