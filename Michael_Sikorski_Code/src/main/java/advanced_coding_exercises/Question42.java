/*
 *  Author: Michael Sikorski
 *  Date: 4/6/18
 */

package advanced_coding_exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question42 {
	
	public Question42() {
		Employee e1 = new Employee("Kevin","Accounting",40);
		Employee e2 = new Employee("Bob","Sales",50);
		Employee e3 = new Employee("Alice","IT",30);		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		System.out.println();
		System.out.println("Original array => " + employees);
		Collections.sort(employees, new nameCompare());
		System.out.println("Sorted by name => " + employees);
		Collections.sort(employees, new deptCompare());
		System.out.println("Sorted by department => " + employees);
		Collections.sort(employees, new ageCompare());
		System.out.println("Sorted by age => " + employees);
	}
	
	class nameCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.name.compareTo(o2.name);
		}
	}
	
	class deptCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.department.compareTo(o2.department);
		}
	}
	
	class ageCompare implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.age - o2.age;
		}
	}
	
	
 

}
