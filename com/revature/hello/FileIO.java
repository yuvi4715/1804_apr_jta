package com.revature.hello;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIO {
	// Consider a text file has the following colon-separated lines:
	// Employee id:First Name:Last Name:Role
	// Read the file, and parse(tokenize) the fields using StringTokenizer with
	// delimiter(:)
	// While parsing the file, place the information in an object, which should have
	// four instance variables: Employee Id, First Name, Last Name, Role.
	// Place these objects in a HashMap with the key as employee id and value as the
	// object
	// i.e HashMap should have[
	// Key: 01 Value : Object representing first line
	// Key: the 02 Value: Object representing second line

	public static void main(String[] args) throws Exception {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/revature/hello/FileRead.txt");
		System.out.println(file);
		Scanner scanner = new Scanner(file);

		System.out.println("reading line from file: ");
		String s = scanner.nextLine(); // read line
		System.out.println("s: " + s);
		StringTokenizer st = new StringTokenizer(s, ":");
		while (st.hasMoreTokens()) {
			System.out.println("st: " + st.nextToken());
		}
		class Employee{
			int employeeID = 0;
			int firstName = 0;
			int lastName = 0;
			int Role = 0;
		}
		new Employee();
		// String ageString = scanner.nextLine(); // read line
		// int age = Integer.parseInt(ageString); // convert String to int
		// System.out.println("age: " + age);
	}

}
