package com.iofile.work;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class ReadFromFile {
	
	public static void main(String[] args) {
		
	String file ="C:\\Users\\franc\\Documents\\workspace-sts-3.9.3.RELEASE\\1804_april2_java\\EmployeeList";
	String line = null;
	HashMap<String, Employee> hm = new HashMap<String, Employee>();
	ArrayList<Employee> al = new ArrayList<Employee>();
	
	@SuppressWarnings("unused")
	Employee e1,e2,e3;
	
	al.add(e1 = new Employee());
	al.add(e2 = new Employee());
	al.add(e3 = new Employee());
	
	try {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		for(Employee emp : al) {
			while((line = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(line);
				
				emp = new Employee(token.nextToken(":"), token.nextToken(":"), token.nextToken(":"), token.nextToken(":"));
				hm.put(emp.getId(), emp);
			}
		}
		br.close();
		
		System.out.println("Listing employees using HashMap");
		System.out.println("~~~~~~~~~~~~~~~~");
		Set<String> key = hm.keySet();
		for(String emp: key) {
			hm.get(emp).getInfo();
			System.out.println();
		}
		
	}
	catch(FileNotFoundException e) {
		System.out.println("Unable to open or find file: " + file);
		
	}
	catch(IOException e) {
		e.printStackTrace();
		}
	}
}
