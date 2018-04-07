package com.revature.questions32_37;

import java.util.Scanner;

public class Question35 {

	
	public static void main(String[] args) {
		
		userScan();
	}
	

	public static void userScan() {
		
		Scanner askUser = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String tempString = askUser.nextLine();
		
		System.out.println("Enter an Integer: ");
		Integer tempInt = Integer.valueOf(askUser.nextLine());
		
		System.out.println("Enter a Double: ");
		Double tempDouble = Double.valueOf(askUser.nextLine());
		
		System.out.println("String: " + tempString);
		System.out.println("Int: " + tempInt);
		System.out.println("Double: " + tempDouble);

		
		askUser.close();
				
		
	}
	
	
}
