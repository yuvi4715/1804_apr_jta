package com.revature.services;

import java.util.ArrayList;

import com.revature.model.Bank;

public class DepositService {

	public static String getBalance(Bank b, String s) {
		return s + ", user has a balance of: " + b.getAccountBalance();
		//return 32423;
	}
	
	public static ArrayList<String> returnArrayList(){
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("This ");
		list.add("is ");
		list.add("part of return value ");
		return list;
	}
}
