package com.revature.bankingApp;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		//executeBank.startBank();
		Scanner userInput = new Scanner(System.in);
		boolean realNumber = false;
		while(realNumber == false) {
			System.out.println("How much would you like to deposit?");
			try {
				BigDecimal deposit = userInput.nextBigDecimal();
				realNumber = true;
			}catch(InputMismatchException e) {
				System.out.println("Not a valid number, please try again.");
				userInput.nextLine();
			}	
		}
		
		
	
		
	}
}
