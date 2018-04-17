package com.revature.advancedCodingExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeCompare {
	String name;
	String department;
	int age;
	
	//problem 42
	public EmployeeCompare(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
		
	}
	public static void main(String[] args) {
		ArrayList<EmployeeCompare> ar = new ArrayList<EmployeeCompare>();
		
		ar.add(new EmployeeCompare("Mitch", "Software", 15));
		ar.add(new EmployeeCompare("Dakota", "Software", 20));
		ar.add(new EmployeeCompare("Andy", "Software", 24));
		ar.add(new EmployeeCompare("Fanyo", "Admin", 15));
		
		Collections.sort(ar, new compareNames());
		for(int i = 0;i<4;i++) {
			System.out.println(ar.get(i).name);
		}
		
		Collections.sort(ar, new compareDepartments());
		for(int i = 0;i<4;i++) {
			System.out.println(ar.get(i).name);
		}
		Collections.sort(ar, new compareAge());
		for(int i = 0;i<4;i++) {
			System.out.println(ar.get(i).name);
		}
	}
}

class compareNames implements Comparator<EmployeeCompare> {

	@Override
	public int compare(EmployeeCompare o1, EmployeeCompare o2) {
		return o1.name.compareTo(o2.name);	
	}
	
}

class compareDepartments implements Comparator<EmployeeCompare> {

	@Override
	public int compare(EmployeeCompare o1, EmployeeCompare o2) {
		return o1.department.compareTo(o2.department);
	}
}

class compareAge implements Comparator<EmployeeCompare> {

	@Override
	public int compare(EmployeeCompare o1, EmployeeCompare o2) {
		return o1.age-o2.age;
	}
}