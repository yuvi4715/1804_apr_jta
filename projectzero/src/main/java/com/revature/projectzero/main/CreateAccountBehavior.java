package com.revature.projectzero.main;

import java.io.PrintStream;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.projectzero.accounts.User;
import com.revature.projectzero.service.BankService;

public class CreateAccountBehavior implements StateBehavior{
	final static Logger log = Logger.getLogger(CreateAccountBehavior.class);
	@Override
	public void execute(PrintStream out) {
		log.debug("createAccountLoop");
		out.println("Please enter the type of account you wish to create");
		out.println("enter \"useraccount(ua)\" to create a user account");
		out.println("enter \"adminaccount(aa)\" to create a admin account");
		out.println("enter \"quit(q)\" to go back to the main menu\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		boolean isAdmin = false;
		if (input.equalsIgnoreCase("useraccount") || input.equalsIgnoreCase("ua")) {
			isAdmin = false;
		} else if (input.equalsIgnoreCase("adminaccount") || input.equalsIgnoreCase("aa")) {
			isAdmin = true;
		} else if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
			Program.setState( ProgramState.mainLoop);
			return;
		} else {
			out.println("Input not understood");
			return;
		} // ELSE

		boolean isUniqueUsername = true;
		String username = null;
		do {
			out.println("Enter username:");
			username = in.nextLine();
			isUniqueUsername = BankService.isUniqueUsername(username);
			if (!isUniqueUsername) {
				out.println("User name taken please pick another!");
				continue;
			} // ELSE
			break;
		} while (true);
		out.println("Username not taken!");
		out.println("Enter Name:");
		String name = in.nextLine();
		out.println("Enter Last Name:");
		String lname = in.nextLine();
		out.println("Enter Password:");
		String password = in.nextLine();
		BankService.create(new User(name, lname, username, isAdmin, false, false, 0L), password);
		out.println("Account Creation Successful");
		Program.setState(ProgramState.mainLoop);
	}

}
