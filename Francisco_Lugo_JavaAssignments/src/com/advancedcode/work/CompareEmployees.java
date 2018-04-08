package com.advancedcode.work;

import java.util.ArrayList;
import java.util.Collections;

public class CompareEmployees {

	public static void main(String[] args) {

		Employee e1 = new Employee("Jerry", "15", "Database");
		Employee e2 = new Employee("Bob", "25", "Front Desk");
		
		ArrayList<Employee> al = new ArrayList<Employee>();
		
		al.add(e1);
		al.add(e2);
		
		Collections.sort(al);
		for(Employee e : al) {
			System.out.println(e.getName());
		}
		
		Collections.sort(al, (o1, o2) -> o1.age.compareTo(o2.age));
		
		for(Employee e : al) {
			System.out.println(e.getDept());
		}
		
		Collections.sort(al, (o1, o2) -> o1.dept.compareTo(o2.dept));
		for(Employee e : al) {
			System.out.println(e.getAge());
		}
	}

}
