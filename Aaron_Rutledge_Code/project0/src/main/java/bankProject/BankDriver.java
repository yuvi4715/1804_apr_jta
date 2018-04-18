package bankProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.*;
import com.revature.service.*;

public class BankDriver {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean bool = true; 
		
		while (bool) {
			bool = menu();
		}
		
	}
	
	static boolean menu() {
	
		
		boolean valFlag = true;
		int choice = 0;
		boolean again = true;

		
		do {
			System.out.println("Welcome to the main menu.");
			System.out.println("1: User login.");
			System.out.println("2: Register as new user.");
			System.out.println("3: Admin Override.");
			System.out.println("4: Exit.");
			System.out.println("Please enter the number corresping to your choice: ");
		
			while (!scanner.hasNextInt()) {
		        System.out.println("That's not a number.");
		        scanner.next();
		    }
		    choice = scanner.nextInt();
		} while (choice < 0 || choice > 4);
		
		
		switch(choice) {
		case(1): 
			
			again = userLogin();
			
			break;
		case(2):
			
			AccountHolder ah = new AccountHolder();
			
			System.out.println("What is your first name? ");
			String fname = scanner.next();
			
			System.out.println("What is your last name? ");
			String lname = scanner.next();
			
			System.out.println("Please enter a password tied to your account. ");
			String pass = scanner.next();
			
			ah.setfName(fname);
			ah.setlName(lname);
			ah.setPass(pass);
			
			if (AccountHolderService.insertAH(ah)) {
				
				System.out.println("Account created!");
				System.out.println("It's status is pending admin approval.");
				System.out.println("Exiting to menu.");
			} else {
				
				System.out.println("Something went wrong.");
				System.out.println("No account created.");
				System.out.println("Exiting to menu.");
			}
			
			
			again = true;
			break;
		case(3):
			
			again = adminLogin();
			
			
			break;
		case(4):
			
			again = false;
			
			break;
		}
		
		return again;
		
	}

	static boolean userLogin() {
		System.out.println();
		String pw = new String();
		int id;
		
		do {
			System.out.println("Please enter your user ID number: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter a number.");
				scanner.next();
			}
			id = scanner.nextInt();
			if (id < 1) {
				System.out.println("The number must be greater than zero.");
			}
		} while (id <= 0);
		
		
		System.out.println("Please enter your password: ");
		pw = scanner.next();
		
		AccountHolder ah = AccountHolderService.login(id,  pw);
		
		if (ah == null) {
			System.out.println("Exiting to main menu.");
			System.out.println();
			
		} else {
			
			//make a function call to user menu
			System.out.println("Login successful.");
			return userMenu(ah);
		}
		
		
		return true;
		
	}
	
	static boolean adminLogin() {
		System.out.println();
		String pw = new String();
		int id;
		
		do {
			System.out.println("Please enter your admin ID number: ");
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter a number.");
				scanner.next();
			}
			id = scanner.nextInt();
			if (id < 1) {
				System.out.println("The number must be greater than zero.");
			}
		} while (id <= 0);
		
		
		System.out.println("Please enter your password: ");
		pw = scanner.next();
		
		BankAdmin ba = BankAdminService.login(id,  pw);
		
		if (ba == null) {
			System.out.println("Exiting to main menu.");
			System.out.println();
			
		} else {
			
			//make a function call to user menu
			System.out.println("Login successful.");
			return adminMenu(ba);
		}
		
		
		return true;
		
	} 
	
	static boolean userMenu(AccountHolder ah) {
		
		int choice;
		boolean repeat;
		
		do {
			do {
			    System.out.println("Welcome, " + ah.getlName() + ".");
			    System.out.println("1: Check Balance.");
			    System.out.println("2: Deposit or Withdraw.");
			    System.out.println("3: Logout.");
			    System.out.println("4: Exit.");
		        
		        
			    while (!scanner.hasNextInt()) {
			        System.out.println("Invalid input.");
			        scanner.next();
			    }
			    choice = scanner.nextInt();
			    if (choice < 1 || choice > 4) {
			    	System.out.println("Please enter a number in range.");
			    }
			} while (choice <= 0);
				
			if (ah.getsFlag() == 0) {
				choice = 0;
				System.out.println("Your user account has not been approved.");
				System.out.println("Exiting to menu.");
				repeat = false;
				
			}
			BankAccount ba;
			switch (choice) {
			case(1): 
				ba = BankAccountService.getBA(((ah.getUserID() * 10) + 1 ));
			
				//System.out.println("Test:  " + ((ah.getUserID() * 10) + 1 ));
				
				System.out.format("Your balance is %.2f%n", ba.getBalance());
				
				repeat = true;
				break;
			case(2):
				
				float amt = 0;
			
				do {
				    System.out.println("Please enter an ammount.");
				    System.out.println("Positive numbers deposit.");
				    System.out.println("Negative numbers withdraw.");
				    
				    
				    while (!scanner.hasNextFloat()) {
				        System.out.println("Invalid input.");
				        scanner.next();
				    }
				    amt = scanner.nextFloat();
				    if (amt == 0) {
				    	System.out.println("Please enter a number other than 0;");
				    }
				} while (amt == 0);
				
				ba = BankAccountService.getBA(((ah.getUserID() * 10) + 1 ));
				ba.setBalance((ba.getBalance() + amt));
				
				if (BankAccountService.updateBA(ba)) {
					
					System.out.format("Success! Your new balance is %.2f%n", ba.getBalance());
				
				} else {
					
					System.out.format("Something went wrong. Your balance is %.2f%n", ba.getBalance());
					
				}
				
				
				
				repeat = true;
				
				break;
			case(3): 
				return true;
			case(4):
				return false;
			default:
				return true;
			}

		} while (repeat);
		
		
		
		
		return false;
	}
	
	static boolean adminMenu(BankAdmin ba) {
		
		int choice;
		boolean repeat;
		
		do {
			do {
			    System.out.println("Welcome, " + ba.getUserName() + ".");
			    System.out.println("1: View Users Needing Approval");
			    System.out.println("2: Approve Users.");
			    System.out.println("3: Logout.");
			    System.out.println("4: Exit.");
		        
		        
			    while (!scanner.hasNextInt()) {
			        System.out.println("Invalid input.");
			        scanner.next();
			    }
			    choice = scanner.nextInt();
			    if (choice < 1 || choice > 4) {
			    	System.out.println("Please enter a number in range.");
			    }
			} while (choice < 1 || choice > 4);
			
			switch (choice) {
			case(1): 
				List<AccountHolder> ahList = AccountHolderService.getAllAH();
				for(AccountHolder i : ahList ) {
					
					System.out.println(i.toString());
					
				}
				System.out.println();
				
				repeat = true;
				break;
			case(2):
				int actNum = 0;
				do {
				    System.out.println("Enter the account number to approve. ");
				    System.out.println("Entering '0' will exit to admin menu.");
				    System.out.println("Account: ");
			        
			        
				    while (!scanner.hasNextInt()) {
				        System.out.println("Invalid input.");
				        scanner.next();
				    }
				    actNum = scanner.nextInt();
				    
				} while (actNum < 0);
				
				BankAccount account = new BankAccount(1, actNum, 0.0);
				
				if (actNum > 0) {
					
					if (AccountHolderService.updateStatus(actNum) && BankAccountService.insertBA(account)) {
						
						System.out.println("Approval was successful!");
						
					} else {
						
						System.out.println("Something went wrong!");
						System.out.println("Exiting back to admin menu.");
					}
					
				}
				
				repeat = true;
				
				break;
			case(3): 
				return true;
			case(4):
				return false;
			default:
				return true;
			}

		} while (repeat);
		
		
		
		
		return false;
		
	}
	
	
}
