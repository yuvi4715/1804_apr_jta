package com.revature.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Request;


public class TrySomeThings {

	public static void main(String[] args) {
		//System.out.println(EmployeeService.insertEmployee(new Employee(0,"test@test.com","Tristan","t","Testin","Testman",true,true)));
//		String username = "Tristan";
//		String password = EmployeeService.getEmployeePassword(username);
//		System.out.println(password);\
//		int i = 5;
//		int[][][][] a1 = new int[i ][i=3][i][i];
//		System.out.println(a1[0].length);
//		System.out.println(a1[0][0].length);
//		System.out.println(a1.length);
//		List<Employee> le = EmployeeService.getAllEmployees();
//		System.out.println(le);
//		Employee e = new Employee(1,"test@test.com","Tristan","t","Testin","Testman",true,false);
//		System.out.println(EmployeeService.updateEmployee(e));
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		Blob b = new Blob();
//		Request request = new Request(1,200.00,1,1,"Pending",null,null, ts, ts);
//		RequestService.insertIntoRequest(request);
		
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		Request request = new Request(3,500.00,2,1,"Pending","Travel",ts,ts);
//		RequestService.insertIntoRequest(request);
//	
		//System.out.println(RequestService.updateReviewed(2, "Approved", 2));
		
		
		EmployeeService.insertEmployee(new Employee(0,"jon","jan","jon","jan", "jon",false, true));
	}

}
