package com.revature.projectzero.main;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.AccountTypes;
import com.revature.projectzero.accounts.Transaction;
import com.revature.projectzero.accounts.User;
import com.revature.projectzero.service.BankService;

public class Program {
	private static ProgramState state = ProgramState.mainLoop;
	private static User u;
	final static Logger log = Logger.getLogger(Program.class);
	private static boolean done = false;

	public static User getU() {
		return u;
	}

	public static void setU(User u) {
		Program.u = u;
	}

	public static boolean isDone() {
		return done;
	}

	public static void setDone(boolean done) {
		Program.done = done;
	}

	public static void setState(ProgramState state) {
		Program.state = state;
	}

	public static ProgramState getState() {
		return state;
	}

	public static void start() {
		StateBehavior mm   = new MainMenuBehavior();
		StateBehavior ull  = new UserLoginLoopBehavior();
		StateBehavior cab  = new CreateAccountBehavior();
		StateBehavior ull2 = new UserLoggedInLoopBehavior(cab);
		do {
			switch (state) {
			case mainLoop:
				mm.execute(System.out);
				break;
			case userLoginLoop:
				ull.execute(System.out);
				break;
			case userLoggedInLoop:
				ull2.execute(System.out);
				break;
			case createAccountLoop:
				cab.execute(System.out);;
				break;
			default:
				done = true;
				break;
			}

		} while (!done);

	}

}
