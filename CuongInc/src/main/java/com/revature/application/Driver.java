package com.revature.application;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.accountcreation.SigningIn;

//Main class to run the application
public class Driver {
	
	//Implementing logging features into the bank application
		final static Logger log = Logger.getLogger(Driver.class);
		
	//Main for the bank application
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		SigningIn.askAccountLogin();
		user.close();
	}
}
