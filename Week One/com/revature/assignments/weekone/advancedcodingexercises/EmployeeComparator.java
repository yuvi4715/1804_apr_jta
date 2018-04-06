/**
 * 
 */
package com.revature.assignments.weekone.advancedcodingexercises;

import java.util.Comparator;

/**
 * @author Ed M
 * @date Apr 6, 2018
 * @time time 12:43:44 PM
 */

//Q42
public class EmployeeComparator {

	/**
	 * 
	 */
	public EmployeeComparator() {
		// TODO Auto-generated constructor stub
	}
	// name, department, and age.

	class Employee {
		String name;
		String department;
		Integer age;

		public Employee(String name, String department, Integer age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}

		public String toString() {
			return this.name + " " + this.department + this.age;
		}
	}

	class SortByName implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	class SortByDepartment implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}
	class SortByAge implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.age.compareTo(b.age);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
