package com.revature.questions24_28;

import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question28 extends Question26 {

	public static void main(String[] args) throws IOException {
		String documentName = "C:\\Users\\Rathalos\\Documents\\Java\\Workplace\\assignment1\\src\\main\\resources\\Question25Employees.txt";
		StringTokenizer tempToken = readFile(documentName);
		Employee emp = new Employee();
		tempEmployee(emp, tempToken);
		Employee emp2 = new Employee();
		tempEmployee(emp2, tempToken);
		Employee emp3 = new Employee();
		tempEmployee(emp3, tempToken);  
		//So far this is just question 27 in order to generate the Employee objects
		
		HashMap<Integer, Employee> employeeHash = new HashMap<>();
		
		employeeHash.put(emp.getEmpID(), emp);
		employeeHash.put(emp2.getEmpID(), emp2);
		employeeHash.put(emp3.getEmpID(), emp3);

		
	}
	
	public static void tempEmployee(Employee emp, StringTokenizer token) {
		emp.setEmpID(Integer.parseInt(token.nextToken()));
		emp.setFname(token.nextToken());
		emp.setLname(token.nextToken());
		emp.setRole(token.nextToken());

	}
	
}
