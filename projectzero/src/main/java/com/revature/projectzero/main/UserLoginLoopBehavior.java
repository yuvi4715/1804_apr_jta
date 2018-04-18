package com.revature.projectzero.main;

import java.io.PrintStream;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.projectzero.service.BankService;

public class UserLoginLoopBehavior implements StateBehavior {
	final static Logger log = Logger.getLogger(UserLoginLoopBehavior.class);
	@Override
	public void execute(PrintStream out) {
		log.debug("userLoginLoop");
		out.println("Welcome please press enter or press quit(q) to return to the previous menu");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
			Program.setState(ProgramState.mainLoop);
			return;
		}
		out.println("Please Enter Username");
		String username = in.nextLine();
		out.println("Please Enter Password");
		String password = in.nextLine();
		Program.setU(BankService.getUserByUsernameAndPassword(username, password));
		if (Program.getU() != null) {
			if (Program.getU().isDeleted()) {
				out.println("Your account has been deleted.");
			} else if (Program.getU().isActive())
				Program.setState(ProgramState.userLoggedInLoop);
			else {
				out.println("Your account has not been activated please contact an administrator.");
			}
		} else
			out.println("Incorrect Login credentials");
	}

}
