package com.revature.bank;

//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.MyIllegalArgumentException;
import com.revature.exceptions.NoMatchingEmailException;
import com.revature.exceptions.NonEmptyAccountException;
import com.revature.exceptions.OverDrawnException;
import com.revature.exceptions.UserHasNotBeenValidatedException;
//import com.revature.dao.UserDaoImpl;
import com.revature.service.BankService;
import com.revature.user.User;



public class UserInterface {
	private static Logger log = Logger.getLogger(UserInterface.class);
	public static void main(String[] args) {
		
		//TODO add in the logging functions and finish the admin and regular user interfaces, most likely will delete
		//the admin doa
		Scanner scan = new Scanner(System.in);
		try {
			/*
			 * Declare my current user of the program if there is one. The only time there will be a current user is
			 * if login is successful, otherwise the other interfaces will not open
			 * Once the user is logged in the system will check if the user is an admin or a regular user
			 * depending on the the answer different interfaces will open up
			 */
			User currentUser;
			String email = loginScreen(scan);
			boolean loggedIn = (email != null);
			if (loggedIn) {
				currentUser = BankService.getUser(email);
				if(currentUser.isAdmin()) {
					//call admin interface with functions
					adminInterface(scan,currentUser);
				}
				else {
					//call regular user interface
					standardUserInterface(scan, currentUser);
				}
			}
		}
		catch(InvalidPasswordException ipe) {
			log.error("=====>>Input invalid password: " +ipe.getMessage(), ipe);
			System.err.println(ipe.getMessage());
		}
		catch(NoMatchingEmailException nmee) {
			log.error("=====>>Entered incorrect email address: " +nmee.getMessage(), nmee);
			System.err.println(nmee.getMessage());
		}
		catch (MyIllegalArgumentException miae) {
			log.error("=====>>Illegal argument thrown: " +miae.getMessage(),miae);
			System.err.println(miae.getMessage());
		}
		catch (InvalidInputException iie) {
			log.error("=====>>Invalid input: " + iie.getMessage(),iie);
			System.err.println(iie.getMessage());
		}
		catch (OverDrawnException ode) {
			log.error("=====>>Overdrawn problem: " +ode.getMessage(),ode);
			System.err.println(ode.getMessage());
		}
		catch (NonEmptyAccountException neae) {
			log.error("=====>>Attempt to delete non-empty account: " + neae.getMessage(),neae);
			System.err.println(neae.getMessage());
		}
		catch (UserHasNotBeenValidatedException uhnbve) {
			log.error("=====>>Non-valid user attempt to login: " +uhnbve.getMessage(),uhnbve);
			System.err.println(uhnbve.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			scan.close();
			System.exit(0);
		}
	}
	
	protected static void adminInterface(Scanner scan, User user) throws NoMatchingEmailException, MyIllegalArgumentException, InvalidInputException {
		boolean notComplete = true;
		while(notComplete) {
			System.out.println("As an admin what would you like to do?");
			System.out.println("(1) Verify pending users, (2) Promote a user to an admin, (3) Update a users info"
					+ "\n(4) View all users currently in the system, (5) logout");
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					String userEmails = "";
					List<String> ar = BankService.findUnverifiedUser();
					System.out.println("Here are the users waiting to be verified: ");
					for (int i =0; i< ar.size(); i++) {
						userEmails = userEmails + ar.get(i) + " ";
					}
					System.out.println(userEmails);
					System.out.println("Enter the email you would like to verify");
					String select = scan.nextLine();
					if(userEmails.contains(select)) {
						if(BankService.updateNotCustomer(select, false)) {
							System.out.println("User has successfully been verified\n");
						}
						break;
					}
					throw new NoMatchingEmailException();
					
				case 2:
					String adminEmails = "";
					List<String> al = BankService.findNonAdminUsers();
					System.out.println("Here are the current non-admin users: ");
					for (int i =0; i< al.size(); i++) {
						adminEmails = adminEmails + al.get(i) + " ";
					}
					System.out.println(adminEmails);
					System.out.println("Enter the email you would like to verify\n");
					String selection = scan.nextLine();
					if(adminEmails.contains(selection)) {
						if(BankService.updateIsAdmin(selection, true)) {
							System.out.println("User has successfully been upgraded to admin");
						}
						break;
					}
					throw new NoMatchingEmailException();
				case 3:
					String allEmails="";
					List<String> allList = BankService.getAllUserEmails();
					System.out.println("Here is a list of all users and potential users");
					for (int i = 0; i<allList.size(); i++) {
						allEmails = allEmails + allList.get(i);
					}
					System.out.println(allEmails);
					System.out.println("Enter the email of the account you would like to alter:");
					String altered = scan.nextLine();
					if (allEmails.contains(altered)) {
						User temp = BankService.getUser(altered);
						System.out.println("Here is the current information for the selected user:");
						System.out.println("Account Number: " + temp.getAccountNumber() + "Email: " + temp.getEmail()
											+ "\nBalance: " + temp.getBalance() + "First Name: " + temp.getFirstName()
											+ "\nLast Name: " + temp.getLastName() + "Admin Status: " + temp.isAdmin()
											+ "\nNot user status: " + temp.getNotCustomer() + "Password: " + temp.getPassword());
						System.out.println("Enter the new email: ");
						String tempEmail = scan.nextLine();
						System.out.println("Enter the new balance: ");
						int tempBalance = scan.nextInt();
						if (tempBalance < 0) {
							throw new MyIllegalArgumentException();
						}
						scan.nextLine();
						System.out.println("Enter new first name: ");
						String tempFirstName = scan.nextLine();
						System.out.println("Enter new last name: ");
						String tempLastName = scan.nextLine();
						System.out.println("Enter 1 if the user will be an admin or 0 if not: ");
						int tempAdminStatus = scan.nextInt();
						scan.nextLine();
						boolean boolAdminStatus;
						if (tempAdminStatus == 1) boolAdminStatus = true;
						else if(tempAdminStatus == 0) boolAdminStatus = false;
						else {
							throw new InvalidInputException();
						}
						System.out.println("Enter 0 if the account is verified and 1 if the account is not: ");
						int tempNotCustomer = scan.nextInt();
						scan.nextLine();
						boolean notCustomer;
						if (tempNotCustomer == 1) notCustomer = true;
						else if (tempNotCustomer == 0) notCustomer = false;
						else {
							throw new InvalidInputException();
						}
						System.out.println("Enter the new password for the user: ");
						String tempPassword = scan.nextLine();
						if (BankService.updateBankUser(new User(temp.getAccountNumber(),tempEmail,tempBalance,tempFirstName,tempLastName,boolAdminStatus,notCustomer,tempPassword))) {
							System.out.println("Update completed successfully\n");
						}
						break;
					}
				case 4:
					System.out.println(BankService.getAllUserEmails());
					break;
				case 5:
					notComplete = false;
					break;
				default:
					throw new InvalidInputException();
			}
		}
	}
	
	protected static String loginScreen(Scanner scan) throws InvalidPasswordException, NoMatchingEmailException, MyIllegalArgumentException, InvalidInputException, UserHasNotBeenValidatedException {
		int choice;
		
		System.out.println("Enter: (1) for Login, (2) for Create Account, or (3) exit");
		choice = scan.nextInt();
		scan.nextLine();
		switch(choice) {
			case 1:
				//search database for all email's, if there is no email that matches throw an error
				//if there is a match return true
				System.out.println("Enter email address: ");
				String newEmail = scan.nextLine();
				List<String> emails = BankService.getAllUserEmails();
				for(int i = 0; i<emails.size(); i++) {
					//check if the email entered matches any in the database
					if(newEmail.equals(emails.get(i))) {
						System.out.println("Enter your password: ");
						String password = scan.nextLine();
						//check if the proper password is input, and if the user has been verified by an admin
						if (password.equals(BankService.checkPassword(newEmail)) && !(BankService.checkIfNotCustomer(newEmail))) {
							return newEmail;
						} 
						else if (!password.equals(BankService.checkPassword(newEmail))) {
							throw new InvalidPasswordException();
						}
						else {
							throw new UserHasNotBeenValidatedException();
						}
					}
				}
				throw new NoMatchingEmailException();
			case 2:
				//take in a email, and check that a password matches what the user input, then submit a user into 
				//database queue for the admin to approve
				System.out.println("Enter your email address: ");
				String addEmail = scan.nextLine();
				System.out.println("Enter your password: ");
				String yourPassword = scan.nextLine();
				System.out.println("Reenter your password: ");
				String reenteredPassword = scan.nextLine();
				if (!(yourPassword.equals(reenteredPassword))) {
					throw new InvalidPasswordException();
				}
				System.out.println("Enter your starting balance you would like to deposit: ");
				double initialDeposit = scan.nextDouble();
				scan.nextLine();
				if (initialDeposit < 0) {
					throw new MyIllegalArgumentException();
				}
				System.out.println("Enter your first name: ");
				String firstName = scan.nextLine();
				System.out.println("Enter your last name: ");
				String lastName = scan.nextLine();
				boolean notCustomer = true;
				boolean isAdmin = false;
				BankService.insertUser(new User(0,addEmail,initialDeposit,firstName,lastName,isAdmin,notCustomer,yourPassword));
				System.out.println("You have successfully enter your account for validation");
				return null;
			case 3:
				return null;
			default:
				throw new InvalidInputException();
		}
	}
	
	protected static void standardUserInterface(Scanner scan, User user) throws InvalidInputException, MyIllegalArgumentException, OverDrawnException, NonEmptyAccountException {
		boolean notComplete = true;
		while(notComplete) {
			System.out.println("As a regular user what would you like to do? ");
			System.out.println("(1) View your account balance, (2) deposit money into your account, (3) withdraw money from"
					+ " your account,\n(4) delete your account if you currently do not hold any money, (5) exit your account");
			int choice = scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println(user.getBalance());
					break;
				case 2:
					System.out.println("How much would you like to deposit? ");
					double deposit = scan.nextDouble();
					if (deposit < 0) {
						throw new MyIllegalArgumentException();
					}
					scan.nextLine();
					BankService.updateUserCheckingAccountBalance(user, deposit);
					user.setBalance(user.getBalance() + deposit);
					break;
				case 3:
					System.out.println("How much money would you like to withdraw from your account?");
					double withdraw = scan.nextDouble();
					if (withdraw > user.getBalance())  {
						throw new OverDrawnException();
					}
					withdraw = withdraw * -1;
					BankService.updateUserCheckingAccountBalance(user, withdraw);
					user.setBalance(user.getBalance() + withdraw);
					break;
				case 4:
					if (user.getBalance() == 0) {
						BankService.deleteUser(user);
						System.exit(0);
					}
					else {
						throw new NonEmptyAccountException();
					}
					break;
				case 5:
					notComplete = false;
					break;
				default:
					throw new InvalidInputException();
			}
		}
	}
}
