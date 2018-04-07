package com.revature.easycoding;

import java.util.Scanner;

public class KeyBoardScanner {

	public static void main(String[] args) {
		
		KeyBoardScanner k = new KeyBoardScanner();
		k.KeyBoardScanner();

	}
	
	public void KeyBoardScanner() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an Integer");
		int a = scan.nextInt();
		System.out.println("You have entered " + a);
		
		System.out.println("Enter a Double data type value");
		double d = scan.nextDouble();
		System.out.println("You have entred " + d);
		
		System.out.println("Enter an String");
		String s = scan.next();
		System.out.println("You have Entered " + "'" +  s + "'");
		
	}

}
