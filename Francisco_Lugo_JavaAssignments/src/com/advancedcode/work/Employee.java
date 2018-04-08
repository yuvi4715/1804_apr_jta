package com.advancedcode.work;

import java.util.Comparator;

public class Employee implements Comparator<Employee>, Comparable<Employee>{
	
	public String name, age, dept;
	
	public Employee(String name, String age, String dept){
		this.name = name;
		this.age = age;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.name.compareTo(e2.name);
	}

	@Override
	public int compareTo(Employee e) {
		return this.name.compareTo(e.name);

	}
}
