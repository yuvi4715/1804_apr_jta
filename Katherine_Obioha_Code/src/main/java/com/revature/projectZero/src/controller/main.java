package com.kobio.controller;

import java.sql.SQLException
;

import com.kobio.model.Person;

public class main {

	static Controller transact;
	
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Bank of Revature" + "\n");
		Controller transact = new Controller();
		transact.menu();
		//transact.generatecreditscore();
	}

}
