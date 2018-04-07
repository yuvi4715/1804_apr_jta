package AdvancedCodingPrograms;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import assignment.Joey.fileio.Employee;

/**
 * 5. Write Comparators to compare two employees 
 * based on their name, department, and age.
 * Combined all comparators into one, could implement different classes to have separate comparators
 */
//Compares employees and place by last name, firstname, department, then age
public class EmployeeCompare{
	//compare with last name first,
	
	public static void main(String[] args) {
		TreeMap <Integer, Employee> compareEmploy = new TreeMap<>(Employee.getEmployeeMap());
		//HashMap<Integer, Employee> temp=new HashMap<>(new EmployeeComparator());
		//HashMap<Integer, Employee> temp=new HashMap<>((s1,s2)-> {return s2.compare(s1);});
		compareEmploy.put(10, new Employee(6, "john", "adams", "PResident"));
		compareEmploy.put(100, new Employee(98, "jn", "as", "PResident"));
		compareEmploy.put(78, new Employee(56, "kyle", "adams", "PResident"));
		for(Entry<Integer, Employee> e: compareEmploy.entrySet()) {
			System.out.println(e);
		}
	}
}
	
	class EmployeeComparator implements Comparator<Employee>{
		@Override
		public int compare(Employee o1, Employee o2) {
			int result=o1.getlName().compareToIgnoreCase(o2.getlName());
			if (result!=0) return result; //compare by lastname
			result = o1.getfName().compareToIgnoreCase(o2.getfName());
			if (result!=0) return result; //compare by firstname
			result = o1.getRole().compareToIgnoreCase(o2.getRole());
			if (result!=0) return result; 
			return o1.getAge()-o2.getAge();
		}
	}
	
	class SingleComparatorModel implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getRole().compareToIgnoreCase(o2.getRole());
		}
		
	}
