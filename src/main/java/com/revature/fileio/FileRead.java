package com.revature.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileRead {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readWriteBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	static void readWriteBytes() throws IOException {
		FileInputStream fis = new FileInputStream("/Users/andrewmcgovern/Documents/workspace-sts-3.9.3.RELEASE/1804_apr_java/src/main/java/com/revature/fileio/employee.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
				
		ArrayList list = new ArrayList();
		
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), ":");
		while (tokenizer.hasMoreTokens()) {
			list.add(tokenizer.nextToken());
		}
			
		String id = (String) list.get(0);
		String firstName = (String) list.get(1);
		String lastName = (String) list.get(2);
		String role = (String) list.get(3);

		Employee theEmployee = new Employee(id, firstName, lastName, role);
		
		HashMap<String, Employee> ht = new HashMap<>();
		ht.put(theEmployee.getId(), theEmployee);
		System.out.println(ht);
		
		fis.close();
		isr.close();
		br.close();
	}
}
