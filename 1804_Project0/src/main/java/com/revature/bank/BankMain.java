package com.revature.bank;

public class BankMain {

	public static void main(String[] args) throws InterruptedException {
		
		BankMenu menu = BankMenu.getInstance();
		
		menu.startApp();
		
		menu.exitApp();
	}
}
