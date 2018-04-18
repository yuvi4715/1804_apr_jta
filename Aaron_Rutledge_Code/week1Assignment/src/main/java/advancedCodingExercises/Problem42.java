package advancedCodingExercises;

import java.util.Comparator;

public class Problem42 {
	
	
	public static void main(String[] args) {
		
		
		
	}
	
	

}

class Employee {
	
	String name;
	String dept;
	int age;
	
	
	
	public Employee() {
		
		name = "";
		dept = "";
		age = 0;
	}
	
	public Employee(String name, String dept, int age) {
		super();
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
}

class EmployeeAgeChecker implements Comparator<Employee> {

	@Override
	public int compare(Employee emp0, Employee emp1) {
		
		return emp0.getAge() - emp1.getAge();
		
	}
	
}

class EmployeeDeptChecker implements Comparator<Employee> {

	@Override
	public int compare(Employee emp0, Employee emp1) {
		
		return emp0.getDept().compareTo(emp1.getDept());
		
	}
	
}

class EmployeeNameChecker implements Comparator<Employee> {

	@Override
	public int compare(Employee emp0, Employee emp1) {
		
		return emp0.getName().compareTo(emp1.getName());
		
	}
	
}