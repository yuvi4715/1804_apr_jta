package com.revature.questions24_28;

import java.io.IOException;
import java.util.StringTokenizer;

public class Question27 extends Question26 {
	
	public static void main(String[] args) throws IOException {
		String documentName = "C:\\Users\\Rathalos\\Documents\\Java\\Workplace\\assignment1\\src\\main\\resources\\Question25Employees.txt";
		StringTokenizer tempToken = readFile(documentName);
		Employee emp = new Employee();
		tempEmployee(emp, tempToken);
		Employee emp2 = new Employee();
		tempEmployee(emp2, tempToken);
		Employee emp3 = new Employee();
		tempEmployee(emp3, tempToken);
		
//		System.out.println(emp3.getEmpID());
//		System.out.println(emp3.getFname());
//		System.out.println(emp3.getLname());
//		System.out.println(emp3.getRole());
		


		
	}

	public static void tempEmployee(Employee emp, StringTokenizer token) {
		
		emp.setEmpID(Integer.parseInt(token.nextToken()));
		emp.setFname(token.nextToken());
		emp.setLname(token.nextToken());
		emp.setRole(token.nextToken());

	}
	
	
}
