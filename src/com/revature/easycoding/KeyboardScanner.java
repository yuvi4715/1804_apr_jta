package com.revature.easycoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//problem 35

public class KeyboardScanner {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		// get int
		System.out.print("Enter an int: ");
		int i = reader.nextInt();

		// get double
		System.out.print("Enter a double: ");
		double d = reader.nextDouble();

		// get string
		System.out.print("Enter a string: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reader.close();
		System.out.println("User input was: " + i + " " + d + " " + s);
	}

}
