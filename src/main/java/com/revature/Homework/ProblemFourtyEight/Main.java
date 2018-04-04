package com.revature.Homework.ProblemFourtyEight;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number:");
		int number = in.nextInt();
		long multiple = 1;
		for(int i=1;i<=number;i++) {
			multiple*=i;
		}
		System.out.println(multiple);
	}
	
}
