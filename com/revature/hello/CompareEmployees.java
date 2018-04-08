package com.revature.hello;

import java.util.ArrayList;
import java.util.Comparator;

public class CompareEmployees {
	public static void main(String[] args) {
		// Write Comparators to compare two employees based on their name, department,
		// and age.
//		CompareEmployees
		Employee x = new Employee("Ian", 4, 34);
		Employee y = new Employee("Bob", 3, 21);
		ArrayList<Employee> a = new ArrayList<>(2);
		a.add(y);
		a.add(x);
		System.out.println("Sort by name:");
		Comparator<Employee> c = new Sortbyname();
		a.sort(c);
		for(Employee e : a) {
			System.out.println(e.name);
		}
		
		System.out.println("Sort by age:");
		Comparator<Employee> ca = new Sortbyage();
		a.sort(ca);
		for(Employee e : a) {
			System.out.println(e.name + " age: " + e.age);
		}
		
		System.out.println("Sort by dept:");
		Comparator<Employee> cd = new Sortbydept();
		a.sort(cd);
		for(Employee e : a) {
			System.out.println(e.name + " dept: " + e.dept);
		}

//		Comparator<Employee> c = new Comparator((Employee x, Employee y) -> y.age - x.age); // LAMBDA
	}
}

class Sortbyname implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}
class Sortbyage implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return b.age - a.age;
	}
}
class Sortbydept implements Comparator<Employee> {
	public int compare(Employee a, Employee b) {
		return a.dept - b.dept;
	}
}

