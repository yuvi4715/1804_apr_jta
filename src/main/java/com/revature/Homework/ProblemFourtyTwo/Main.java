package com.revature.Homework.ProblemFourtyTwo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static final String[] Names = {
			"Carl",
			"Jenny",
			"Ludachris"
	};
	final static String[] Departments = {
			"Kitchen",
			"Accounting",
			"Human Resources"
	};
	final static String[] Roles = {
			"Programmer",
			"Chef",
			"Secretary"
	};
	public static void main(String[] args) {
		List<Employee> lEmp = new LinkedList<Employee>();
		for(int i=0;i<20;i++)
		{
			lEmp.add(new Employee(Names[(int)(Math.random()*Names.length)],
					"Jr.",
					Roles[(int)(Math.random()*Roles.length)],
					Departments[(int)(Math.random()*Departments.length)],
					(long) (Math.random()*1000L), 
					(short) (18+Math.random()*70)));
		}
		System.out.println("Sort by ID: ");
		Collections.sort(lEmp, new SortByID());		
		for(Employee e:lEmp)
			System.out.println(e);
		System.out.println("Sort by Age: ");
		Collections.sort(lEmp, new SortByAge());		
		for(Employee e:lEmp)
			System.out.println(e);
		System.out.println("Sort by Name: ");
		Collections.sort(lEmp, new SortByName());		
		for(Employee e:lEmp)
			System.out.println(e);
		System.out.println("Sort by Department: ");
		Collections.sort(lEmp, new SortByDepartment());		
		for(Employee e:lEmp)
			System.out.println(e);
	}	
}
