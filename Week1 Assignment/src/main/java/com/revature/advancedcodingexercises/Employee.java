package com.revature.advancedcodingexercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
	/*
	 * 42. Write Comparators to compare two employees based on their name,
	 * department, and age.
	 */
	String name;
	String department;
	int age;
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public static void main(String[] args) {
		ArrayList<Employee> CuongInc = new ArrayList<Employee>();
		CuongInc.add(new Employee("Bob", "HR", 26));
		CuongInc.add(new Employee("Sara", "Engineer", 27));
		Collections.sort(CuongInc, new compareDepartment());
		System.out.println(CuongInc.get(0));
		System.out.println(CuongInc.get(1));
		
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}

	class compareDepartment implements Comparator<Employee>
	{
		public int compare(Employee Bob, Employee Sara) {
			return Bob.department.compareTo(Sara.department);
		}
	}
