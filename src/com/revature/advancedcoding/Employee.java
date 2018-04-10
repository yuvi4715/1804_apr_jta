package com.revature.advancedcoding;

//problem 42
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparator<Employee> {
	private String name;
	private String department;
	private int age;

	public static void main(String[] args) {
		List<Employee> ar = new ArrayList<Employee>();
		ar.add(new Employee("Joe", "HR", 30));
		ar.add(new Employee("Samantha", "Industrial", 30));
		ar.add(new Employee("Andy", "HR", 50));
		ar.add(new Employee("Joyce", "Construction", 25));
		
		System.out.println(ar);
		Collections.sort(ar, new Employee());
		
		
		for(Employee a: ar)   // printing the sorted list of names
	         System.out.print(a.getAge() + ", ");

	      // Sorts the array list using comparator
	      Collections.sort(ar, new Employee());
	      System.out.println(" ");
	      
	      for(Employee a: ar)   // printing the sorted list of ages
	         System.out.print(a.getName() +"  : "+ a.name + ", ");
		
		
	}

	
	@Override
	public int compare(Employee e1, Employee e2) {
		//return (e1.age - e2.age);
		int c = (e1.age - e2.age);
			if(c!=0) {
				return c;
			}
			/*
			else if ( (e1.name).equals(e2.name) ){
			return;
			}
			*/
			
			}
		//else compare the strings and return that
		return c;
	}


	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public Employee() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}





}
