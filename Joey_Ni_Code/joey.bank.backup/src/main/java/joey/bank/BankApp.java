package joey.bank;

import java.sql.Connection;
import java.util.List;

import joey.bank.model.BankAdmin;
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
		 *5. create new bank account for new user, initial deposits
		 *6. user login, get username, get balance
		 *7. user request deposit/withdrawal  !!!
		 *8. admin approves deposit/withdrawal
		 */
		BankService.openBank(); //opens bank/connection to database
	//	BankService.createAdmin("tom7", "hellowworld","Poorest", "Richest");//create bank admin: usrname, pass, ln, fn
	//	BankService.createAdmin("tomIII", "hellowworld","Richest", "BankAdmin1"); //Bank admin cannot create other admin
	//	BankService.createAdmin("joeyni", "helloworld", "ni", "joey"); //Demo
		//user create account, background process: added by admin, user does not care about who the admin is
	//	BankService.getAllUsers();
	//	System.out.println(BankService.getUser("lastname","richest"));
	//	BankService.createAccount(BankService.getUser("lastname","richest")); //as many accounts as you want
	//	System.out.println(BankService.deleteUser("jackson6", "helloworld"));
	//	BankService.insertUser("jackson8","helloworld","richest","lastname", 169); //add user
	//	BankService.createAccount(BankService.getUser("richest", "lastname")); //create new bank account
	//	BankService.deposit(BankService.getUser("richest", "lastname"), 300); //deposit
	//	BankService.getBalance(BankService.getUser("richest", "lastname")); //CHECK BALANCE
	//	BankService.withdraw(BankService.getUser("richest", "lastname"), 300);
	//	BankService.insertUser("joeyusertest","joeypass","joeylast","joeyfirst", 169); //most recent test user
	//	BankService.getUser("lastname", "richest"); //jackson8 lastname, firsname
	//	BankService.getBalance("jackson8", "helloworld"); //jackson8 username, password
	//	BankService.deposit("joeyusertest", "joeypass", 300);
	//	BankService.withdraw("joeyusertest", "joeypass", 100);
		/*BankUser getUser(String lastname, String firstname);
	boolean deposit(float amount);
	boolean withdraw(float amount);
	float getBalance(String username, String password);*/
		
	//	System.out.println(BankService.getAllUsers());
		/*List<BankUser> users = BankService.getAllUsers();
		for(BankUser b: users) {
		System.out.println(b);
		}
		
		//BankService.closeBank(); //close for admin session
		//BankService.userConnect(); //user login
		//BankService.getUser(lastname, firstname)
		
	//	BankService.updateAccount(user,amount);
		/* user_id NUMBER(8,0) CHECK (user_id BETWEEN 0 AND 99999999) PRIMARY KEY, 
		   account_number NUMBER CHECK (account_number BETWEEN 0 AND 99999999), 
		   admin_id NUMBER(8,0) CHECK (admin_id BETWEEN 0 AND 99999999),
		   firstname VARCHAR2(16) NOT NULL, --20 bytes max
		   lastname VARCHAR2(16) NOT NULL,  --20 char max
		   username VARCHAR(16) NOT NULL, --16char max
		   password VARCHAR2(16) NOT NULL --16char max*/
	    
		//Need Admin approval, which approves only if user does not have an user account yet
		//BankService.insertUser(new BankUser(1, 18, "George", "Washington", "gw1st","helloworld"));
		//BankService.insertUser(new BankUser(2, 18, "Thomas", "Jefferson", "gw1st","helloworld"));
	//	BankService.closeBank();
	//	BankService.openBank();
	/*	BankService.insertUser(new BankUser(3, 18, "John", "Adams", "gw1st","helloworld"));
		BankService.closeBank();
		BankService.openBank();
		BankService.insertUser(new BankUser(4, 19, "Andrew", "Jackson", "gw1st","helloworld"));
		//BankUser mm =BankService.getUser("George", "Washington");
		//System.out.println(mm.toString());
		BankService.closeBank();
		BankService.openBank();
		
		
		
		
		
		*/
		BankService.closeBank(); //close bank/connectino to database
	}

}
