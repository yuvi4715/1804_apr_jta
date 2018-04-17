package joey.bank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import joey.bank.model.BankService;
import joey.bank.model.BankUser;

/**
 * A BankApp that can withdraw and deposit a $float amount into an user account 
 * stored in specified bank_db. 
 * Users have to be approved and added by a bank admin in order to create an user account in bank_db.
 * Each bank must have at least one admin. 
 * An admin can be a normal user+admin or just an admin with no bank account.
 * An user can use this bank app to deposit and withdraw money from his/her bank account
 * @author joeyi
 *
 */
public class BankApp {
	public static void main(String[] args) {
		/*1. open bank
		 * 2. create admin
		 *3. login as admin
		 *4. insert new user
		 *5. create new bank account for new user, admin can do initial deposits
		 *6. user login, get username, get balance
		 *7. user request deposit/withdrawal
		 *8. admin approves deposit/withdrawal and got notified of row updates
		 */
		
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to The Richest Bank");
		System.out.println("Please enter your username");
		String username = console.next();
		System.out.println("Please enter your password");
		String password = console.next();
		
		Properties props =new Properties();
		try(OutputStream out=new FileOutputStream("src/main/resources/userdb.properties")) 
		{
			props.setProperty("username", username);
			props.setProperty("password", password);
			props.store(out, null);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BankService.openBank(); //opens bank/connection to database
		int menu=BankService.selectMenu(username, password);
		while(true) {
		switch(menu)
		{
		case 0: System.out.println("Welcome Boss: " +username + " You got a new employee?"); 
				System.out.println("0: Create admin");
				
				break;
		case 1: System.out.println("Welcome BankAdmin: " +username);
				System.out.println(" Here's your Menu");
				System.out.println("1. Add a new bank user/create account for user");
				System.out.println("2. Make a deposit on behalf of an user");
				System.out.println("3. Get all users");
				System.out.println("4. Get complete user info");
				break;
		case 2: System.out.println("Welcome Bank User: " + username + " Menu"); 
				System.out.println("5.Get balance 6.Make a deposit 7. Make a withdrawal");
				System.out.println("8. Retrieve your secret account number");
				break;
		case 3: System.out.println("Sorry you have not signed up yet.");
				System.out.println("Please see one of our admins to sign up or visit our branch in Reston to sign up");
				break;
		default: System.out.println("Some error happened. Please visit later");
		}
		String name;
		String pass;
		String last;
		String first;
		int depo=0;
		int action = console.nextInt();
		switch(action)
		{
			case 0: System.out.println("Create admin: please enter username, password, lastname, firstname separated by space");
					name=console.next();
					pass=console.next();
					last=console.next();
					first=console.next();
					BankService.createAdmin(name, pass, last, first); //create bank admin, insert into table, grant role
					//Bank admin cannot create other admin
					System.out.println("Admin created and granted access and privileges.");
					break;
			case 1: System.out.println("Create user: please enter username, password, lastname, firstname separated by space ");
					System.out.println("Also include your admin id");
					name=console.next();
					pass=console.next();
					last=console.next();
					first=console.next();
					int admin=console.nextInt();
					BankService.insertUser(name, pass, last, first, admin);
					BankUser temp=new BankUser(name, pass, last, first);
					BankService.createAccount(temp);
					System.out.println("New user: "+BankService.getUser(last, first));
					System.out.println("New Bank Account: "+BankService.getAccountNumber(temp));
					System.out.println("Initial deposit: ");
					depo=console.nextInt();
					BankService.deposit(temp, depo);
					System.out.println("New balance: " +BankService.getBalance(BankService.getId(name, pass)));
					break;
			case 2: System.out.println("Please enter bank account number");
			        int acnum=console.nextInt();
			        System.out.println("Please enter amount");
					depo=console.nextInt();
					BankService.deposit(acnum, depo);
					System.out.println(BankService.getBalance(acnum));
					break;
			case 3: List<BankUser> users = BankService.getAllUsers();
					for(BankUser b: users) { System.out.println(b);}
					break;
			case 4: System.out.println("Enter user lastname and firstname");
			        String lastname=console.next();
			        String firstname=console.next();
					System.out.println(BankService.getUser(lastname, firstname));
					System.out.println("From the username gotten from previous result, can get to all other ops getId, getAccount, getBalance etc.");
					break;
			case 5: System.out.println("Your balance is:"+ BankService.getBalance(username, password));
					break;
			case 6: //user deposit
					int uid=BankService.getId(username, password);
					int acct=BankService.getAccountNumber(uid);
					System.out.println("Enter amount to deposit");
					depo=console.nextInt();
					System.out.println(username+ password);
					BankService.deposit(acct, depo);
					break;
			case 7: System.out.println("Enter amount to withdraw");
					depo=console.nextInt();
					uid=BankService.getId(username, password);
					acct=BankService.getAccountNumber(uid);
					BankService.withdraw(acct, depo);
					break;
			case 8: uid=BankService.getId(username, password);
				    acct=BankService.getAccountNumber(uid);
					System.out.println("Your user id" +uid);
			        System.out.println("Your bank account #: "+acct);
			    
		
		}
	
		BankService.closeBank();
	
	//To cheat into this system: get admin last name, get admin id, create user using that admin id...
		}
	}

}
