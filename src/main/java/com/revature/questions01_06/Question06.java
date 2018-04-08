package com.revature.questions01_06;

import java.util.Scanner;

public class Question06 {
	
	public static void main(String[] args) {
		interactive_controlStatement();
	}
	
	public static void interactive_controlStatement() {
		Scanner sc = new Scanner(System.in);
		
		int anynumber;
		int i = 0;
		
		System.out.println("Enter random whole number:");
		anynumber = sc.nextInt();
		
		if (anynumber > 10) {
			System.out.println("Your number is greater than ten.");
		}
		else{
			System.out.println("Your number is ten or less.");
		}
		
		System.out.println("Count up to number with a while loop.");
		while(i <= anynumber) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println("\nNow to count down using a for loop:");
		for(int j = i; j > 0; j-=1) {
			System.out.print(j + " ");	
		}
		
		sc.close();
	}

}
