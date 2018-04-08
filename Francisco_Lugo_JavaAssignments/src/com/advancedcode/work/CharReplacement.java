package com.advancedcode.work;

import java.util.Scanner;

public class CharReplacement {

	public static void main(String[] args) {

		int num;
		char rep;
		String str = "This is the string, hi there!";
		char[] strArray = str.toCharArray();
		Scanner input = new Scanner(System.in);
		
		System.out.println(str);
		System.out.println("What letter would you like to replace in the above sentence?");
		
		try {
			num = input.nextInt();
			
			System.out.println("For what letter would you like to replace it with?");
			
			rep = input.next().charAt(0);
			
			strArray[num] = rep;
			
			System.out.println(strArray);
		}
		catch(NumberFormatException e) {
			System.out.println("Something went wrong, did you input the right thing?");
		}
		input.close();
	}

}
