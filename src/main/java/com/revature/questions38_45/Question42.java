package com.revature.questions38_45;

import java.util.Comparator;

public class Question42 {

	public static void main(String[] args) {

		Employee42 emp1 = new Employee42(42,"Frank", "HR");
		Employee42 emp2 = new Employee42(12, "Lucy", "Dev Ops");
		Employee42 emp3 = new Employee42(20, "Yuvi", "CEO");
		Employee42 emp4 = new Employee42(71, "Trump", "Mean Guy");
		Employee42 emp5 = new Employee42(42, "Lucy", "Mean Guy");
	
		EmpAgeCheck checkAge = new EmpAgeCheck();
		System.out.println("They are separated by " + checkAge.compare(emp1, emp2) + " years in age.");
		System.out.println("They are separated by " + checkAge.compare(emp1, emp5) + " years in age.");
		
		EmpDeptCheck checkDept = new EmpDeptCheck();
		System.out.println(checkDept.compare(emp2, emp3));
		System.out.println(checkDept.compare(emp1, emp5)); 
		System.out.println(checkDept.compare(emp4, emp5)); // 0 because same dept
		
		EmpNameCheck checkName = new EmpNameCheck();
		System.out.println(checkName.compare(emp1, emp2));
		System.out.println(checkName.compare(emp2, emp5)); // 0 because same name
		System.out.println(checkName.compare(emp3, emp5));
		
		//.compare can only return int so I couldn't do a boolean or something
	}

}

class EmpAgeCheck implements Comparator<Employee42> {

	@Override
	public int compare(Employee42 emp0, Employee42 emp1) {
		return emp0.getAge() - emp1.getAge();

	}
}

class EmpDeptCheck implements Comparator<Employee42> {

	@Override
	public int compare(Employee42 emp0, Employee42 emp1) {
		return emp0.getDepartment().compareTo(emp1.getDepartment());

		
	}
}

class EmpNameCheck implements Comparator<Employee42> {

	@Override
	public int compare(Employee42 emp0, Employee42 emp1) {
		return emp0.getName().compareTo(emp1.getName());

	}
}
