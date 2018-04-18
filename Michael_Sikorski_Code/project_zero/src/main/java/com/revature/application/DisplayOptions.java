package com.revature.application;

import java.util.ArrayList;

import com.revature.model.User;

public class DisplayOptions {
	
	//private ArrayList<String> options;
	
	public static ArrayList<String> options(User u) {
		ArrayList<String> options = new ArrayList<>();
		if (u.isAdmin()) {
			options.add("View Accounts");
			options.add("Verify Accounts");
			options.add("View Transactions");
			options.add("Log off");
		} else {
			options.add("View Balance");
			options.add("Withdrawal");
			options.add("Deposit");
			options.add("Log off");
		}
		return options;
	}
}
