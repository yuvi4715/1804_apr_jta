package com.revature.main;

import java.util.Scanner;

public class App {

	public static void run() {
		Scanner sc = new Scanner(System.in);
		String un = null, pw = null;
		System.out.println("Hello!  Welcome to [bank]'s banking app!  Please enter your username now");
		while(true) {
			System.out.print("Username: ");
			un = sc.nextLine();
			//Search the database for that username
			//if(username exists)
				System.out.println("Welcome, " + un + "!  Please enter your password below");
				System.out.print("Password: ");
				pw = sc.nextLine();
				//if correct password
					System.out.println("Login successful!");
				//else
					System.out.println("That password does not match our records.  Please try again.");
			//else
				System.out.println("We do not have a record of that username.  Please try again.");
		}
	}
}
