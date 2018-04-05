package com.revature.fileio;

//Part of the solution to hw1 problem #24 - #28

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileIOMain {

	HashMap<Integer, Employee> readFile(BufferedReader reader) throws IOException {
		
		String line = reader.readLine();
		StringTokenizer tokenizer;
		HashMap<Integer, Employee> employeeRecords = new HashMap<Integer, Employee>();
		
		while (line != null) {
			tokenizer = new StringTokenizer(line, ":");
			
			String eid = tokenizer.nextToken();
			String firstName = tokenizer.nextToken();
			String lastName = tokenizer.nextToken();
			String role = tokenizer.nextToken();
			Integer eidInt = Integer.parseInt(eid);
			
			Employee currEmployee = new Employee(eidInt, firstName, lastName, role);
			
			employeeRecords.put(eidInt, currEmployee);
			
			line = reader.readLine();
		}
		
		return employeeRecords;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/employees.txt"));
		
		HashMap<Integer, Employee> employeeRecords = new FileIOMain().readFile(reader);	
		reader.close();
		
		System.out.println(employeeRecords);
	}
}
