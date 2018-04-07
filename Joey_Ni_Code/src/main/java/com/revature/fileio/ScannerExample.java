package com.revature.fileio;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {
		System.out.println("what's your name");
		Scanner n= new Scanner(System.in);
		System.out.println("your name is "+n.nextLine());
		System.out.println("what's your age");
		System.out.println("your age is " + n.nextInt());
	}

}
