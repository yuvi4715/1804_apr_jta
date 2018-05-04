package com.revature.fileio;

import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = scanner.nextLine(); // read line
		System.out.println("name: " + name);
		System.out.println("Enter your age: ");
		String ageString = scanner.nextLine(); // read line
		int age = Integer.parseInt(ageString); // convert String to int
		System.out.println("age: " + age);
	}
}
