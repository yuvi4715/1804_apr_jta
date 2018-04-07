package advanced_coding;

import java.util.Comparator;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 42.
//This class compares to employees bases on their age, name, and department
//using a class that implements Comparator<>

public class Prob_42 {
	int age;
	String department;
	String Name;
	
	public Prob_42() {
		
	}
	
	public Prob_42(int age, String department, String name) {
		super();
		this.age = age;
		this.department = department;
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public static void main(String[] args) {
		Prob_42 emp1, emp2, emp3;
		emp1 = new Prob_42(40,"IT","Kevin");
		emp2 = new Prob_42(40, "IT", "Kevin");
		emp3 = new Prob_42(34, "HR", "Peter");
		
		//0 means they are equal, otherwise they are not.
		System.out.println(new EmployeeHelper().compare(emp1, emp2));
		System.out.println(new EmployeeHelper().compare(emp1, emp3));
	}
	
}

class EmployeeHelper implements Comparator<Prob_42>{

	//Use this method to compare if two employees are equal
	@Override
	public int compare(Prob_42 emp1, Prob_42 emp2) {
		if(emp1.getAge() == emp2.getAge() 
				&& emp1.getDepartment().equals(emp2.getDepartment())
				&& emp1.getName().equals(emp2.getName()))
			return 0;
		else
			return 1;
		
	}
}