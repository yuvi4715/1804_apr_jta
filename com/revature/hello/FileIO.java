package com.revature.hello;

import java.io.File;
import java.util.HashMap;
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
		HashMap<Integer, Employee> map = new HashMap<>();

		while (scanner.hasNextLine()) {
			System.out.println("reading line from file...");
			String s = scanner.nextLine(); // read line
			System.out.println("s: " + s);
			StringTokenizer st = new StringTokenizer(s, ":");

			// parse line
			while (st.hasMoreTokens()) {
				String e = st.nextToken();
				int employeeID = Integer.parseInt(e); // convert String to int
				// System.out.println("employeeID: " + e);
				String f = st.nextToken();
				// System.out.println("firstName: " + f);
				String l = st.nextToken();
				// System.out.println("lastName: " + l);
				String r = st.nextToken();
				// System.out.println("role: " + r);

				map.put(employeeID, new Employee(employeeID, f, l, r));
			}
		}
		// print map
		System.out.println("Printing the map: ");
		for (int k : map.keySet()) {
			System.out.println(map.get(k));
		}
	}

}
