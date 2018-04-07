/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

import java.util.Comparator;

class Employee {
	public String name;
	public String department;
	public int age;

	public Employee(String n, String d, int a) {
		name = n;
		department = d;
		age = a;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}



	class nameCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	class deptCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	class ageCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}