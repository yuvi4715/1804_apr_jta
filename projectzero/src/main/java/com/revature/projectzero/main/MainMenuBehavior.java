package com.revature.projectzero.main;

import java.io.PrintStream;
import java.util.Scanner;

import org.apache.log4j.Logger;

public  class MainMenuBehavior implements StateBehavior {
	final static Logger log = Logger.getLogger(MainMenuBehavior.class);
	
	
	@Override
	public void execute(PrintStream out) {
		log.debug("mainLoop");
		out.println("Welcome to Ipsum Bank!\n" + "Options are:\n" + "enter \"login(l)\" to log into an account\n"
				+ "enter \"createAccount(ca)\" to create an account\n" + "enter \"quit(q)\" to quit the application\n");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if (input.equalsIgnoreCase("login") || input.equalsIgnoreCase("l")) {
			Program.setState(ProgramState.userLoginLoop);
		} else if (input.equalsIgnoreCase("createaccount") || input.equalsIgnoreCase("ca")) {
			Program.setState(ProgramState.createAccountLoop);
		} else if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
			Program.setDone(true);
		}
	}

}
