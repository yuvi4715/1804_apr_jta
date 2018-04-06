package com.revature.AdvancedCodingExercises;

import java.util.Comparator;

import com.revature.FileIO.Employee;

public class Q42Comparators{
	
}
	
class idComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId() - o2.getId();	
	}
}

class departmentComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getRole().compareTo(o2.getRole());
	}
	
}

class nameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		int result = o1.getFirstName().compareTo(o2.getFirstName());
		if(result != 0) {
			return result;
		}
		else {
			return o1.getLastName().compareTo(o2.getLastName());
		}
			
	}
	
}